package com.hugothomaz.rotafrete.screen.freight

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.hugothomaz.domain.interactor.CalcFreightUseCase
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.PointModel
import com.hugothomaz.domain.model.RouterModel
import com.hugothomaz.domain.model.enums.OperationPointEnum
import com.hugothomaz.rotafrete.screen.freight.states.FreightStates
import com.hugothomaz.rotafrete.screen.freight.states.FreightStatesView
import com.hugothomaz.rotafrete.screen.freight.steps.FragmentPoint
import io.reactivex.schedulers.Schedulers
import java.util.NoSuchElementException

class FreightViewModel(
    private val calcFreightUseCase: CalcFreightUseCase
) : ViewModel() {

    val statesView: FreightStatesView = FreightStatesView()

    private val freightModelMutableLiveData = MutableLiveData<FreightModel>()
    val freightModelLiveData: LiveData<FreightModel>
        get() = freightModelMutableLiveData

    private val statesMutableLiveData = MutableLiveData<FreightStates>()
    val states: LiveData<FreightStates>
        get() = statesMutableLiveData


    fun calcFreight() {
        states.run {
            calcFreightUseCase.execute(
                RouterModel(
                    pointModelStart = statesView.pointStart.value!!,
                    pointModelEnd = statesView.pointEnd.value!!,
                    axis = statesView.numberAxis ?: 0,
                    fuelConsumption = statesView.fuelConsumption,
                    fuelPrice = statesView.fuelPrice
                ),
                hasReturnShipment = true
            )
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { it ->
                        Log.d("app_subscribe", it.distance.toString())
                        statesMutableLiveData.postValue(FreightStates.SuccessCall)
                        freightModelMutableLiveData.postValue(it)
                    },
                    {
                        Log.d("app_subscribe", "Deu erro: ${it.message}")
                        statesMutableLiveData.postValue(FreightStates.Error(it.message ?: ""))
                    }

                )
        }
    }

    fun addPoint(latLng: LatLng, operation: OperationPointEnum) {
        if (operation.equals(OperationPointEnum.OPERATION_START)) {
            statesView.pointStart.postValue(PointModel(latLng.latitude, latLng.longitude))
        } else if (operation.equals(OperationPointEnum.OPERATION_END)) {
            statesView.pointEnd.postValue(PointModel(latLng.latitude, latLng.longitude))
        }
    }

    fun removePoint(operation: OperationPointEnum) {
        if (operation.equals(OperationPointEnum.OPERATION_START)) {
            statesView.pointStart.postValue(null)
        } else if (operation.equals(OperationPointEnum.OPERATION_END)) {
            statesView.pointEnd.postValue(null)
        }
    }

    fun next() {
        statesView.nextStep()
    }

    fun onDestroy(){

    }

}