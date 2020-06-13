package com.hugothomaz.rotafrete.screen.main

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hugothomaz.domain.exception.NotFoundID
import com.hugothomaz.domain.interactor.GetAllFreightUseCase
import com.hugothomaz.domain.interactor.GetFreightUseCase
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.rotafrete.core.SingleLiveEvent
import com.hugothomaz.rotafrete.screen.main.state.MainStatesAction
import com.hugothomaz.rotafrete.screen.main.state.MainStatesView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainViewModel(
    val fetFreightUseCase: GetFreightUseCase,
    val getAllFreightUseCase: GetAllFreightUseCase
) : ViewModel() {

    var statesView = MainStatesView()
        private set

    private val statesActionMutable = SingleLiveEvent<MainStatesAction>()
    val statesAction: LiveData<MainStatesAction>
        get() = statesActionMutable

    @SuppressLint("CheckResult")
    fun openFreight(freightModel: FreightModel) {
        fetFreightUseCase.getFreightByID(freightModel.id)
            .subscribe({
                statesActionMutable.postValue(MainStatesAction.SelectFreight(it))
            }, {
                handlerError(it)
            })
    }

    @SuppressLint("CheckResult")
    fun requestListFreight() {
        getAllFreightUseCase.fetchAllFreight()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    statesActionMutable.postValue(MainStatesAction.ListFreights(list))
                },
                { e ->
                    handlerError(e)
                }
            )
    }

    private fun handlerError(exception: Throwable) {
        when (exception) {
            is NotFoundID -> {
                statesActionMutable.postValue(MainStatesAction.Error(exception.message ?: ""))
            }
            else -> {
                statesActionMutable.postValue(MainStatesAction.Error("Um erro inesperado ocorreu"))
            }


        }
    }

}