package com.hugothomaz.rotafrete.screen.freight

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.hugothomaz.domain.interactor.CalcFreightUseCase
import com.hugothomaz.domain.interactor.GetFreightUseCase
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.PointModel
import com.hugothomaz.domain.model.RouterModel
import com.hugothomaz.domain.model.enums.OperationPointEnum
import com.hugothomaz.rotafrete.screen.freight.states.FreightStates
import com.hugothomaz.rotafrete.screen.freight.states.FreightStatesView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FreightViewModel(
    private val calcFreightUseCase: CalcFreightUseCase,
    private val getFreightUseCase : GetFreightUseCase
) : ViewModel() {

    var statesView: FreightStatesView = FreightStatesView()

    private val freightModelMutableLiveData = MutableLiveData<FreightModel>()
    val freightModelLiveData: LiveData<FreightModel>
        get() = freightModelMutableLiveData

    private val statesMutableLiveData = MutableLiveData<FreightStates>()
    val states: LiveData<FreightStates>
        get() = statesMutableLiveData

    fun check(){
        statesMutableLiveData.postValue(FreightStates.ToCalc)
    }

    fun calcFreight() {
        states.run {
            calcFreightUseCase.execute(
                RouterModel(
                    pointModelStart = statesView.pointStart!!,
                    pointModelEnd = statesView.pointEnd!!,
                    axis = statesView.numberAxis ?: 0,
                    fuelConsumption = statesView.fuelConsumption,
                    fuelPrice = statesView.fuelPrice
                ),
                hasReturnShipment = true
            ).doOnSubscribe {
                statesMutableLiveData.postValue(FreightStates.Load)
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { it ->
                        statesMutableLiveData.postValue(FreightStates.SuccessCalc(it))
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
            statesView.pointStart = PointModel(latLng.latitude, latLng.longitude)
        } else if (operation.equals(OperationPointEnum.OPERATION_END)) {
            statesView.pointEnd = PointModel(latLng.latitude, latLng.longitude)
        }
    }

    fun removePoint(operation: OperationPointEnum) {
        if (operation.equals(OperationPointEnum.OPERATION_START)) {
            statesView.pointStart = null
        } else if (operation.equals(OperationPointEnum.OPERATION_END)) {
            statesView.pointEnd = null
        }
    }

    fun next() {
        statesView.nextStep()
    }

    fun onDestroy(){
        statesView = FreightStatesView()
        freightModelMutableLiveData.postValue(null)
        statesMutableLiveData.postValue(null)
    }

}