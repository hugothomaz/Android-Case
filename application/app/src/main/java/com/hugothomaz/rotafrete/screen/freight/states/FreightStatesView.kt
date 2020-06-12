package com.hugothomaz.rotafrete.screen.freight.states

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hugothomaz.domain.model.PointModel
import com.hugothomaz.rotafrete.BR
import com.hugothomaz.rotafrete.core.SingleLiveEvent


class FreightStatesView : BaseObservable() {

    companion object {
        const val AXIS = 0
        const val FUEL_PRICE = 1
        const val CONSUMPTION = 2
        const val POINT_START = 3
        const val POINT_END = 4
        const val RESUME = 5
    }

    private val MSG_AXIS_NOT_FILLED = "Informe o número de eixos"
    private val MSG_FUEL_PRICE_NOT_FILLED = "Informe o preço do combustível"
    private val MSG_FUEL_CONSUMPTION_NOT_FILLED = "Informe o consumo de combustível"
    private val MSG_POINT_START_NOT_FILLED = "Informe o ponto de partida da rota"
    private val MSG_POINT_END_NOT_FILLED = "Informe o ponto final da rota"

    //Step at the moment
    private var step: Int = AXIS

    //Field related to the step of the moment is filled
    private var statesMutable = SingleLiveEvent<FreightStates>()
    val states: LiveData<FreightStates>
        get() = statesMutable

    @Bindable
    var showButtonCalc: Boolean = false
        private set(value) {
            field = value
            notifyPropertyChanged(BR.showButtonCalc)
        }

    @Bindable
    var showButtonExit: Boolean = true
        private set(value) {
            field = value
            notifyPropertyChanged(BR.showButtonExit)
        }

    @Bindable
    var showButtonNext: Boolean = true
        private set(value) {
            field = value
            notifyPropertyChanged(BR.showButtonNext)
        }

    @Bindable
    var numberAxis: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.numberAxis)
        }

    var pointStart : PointModel ?= null

    var pointEnd : PointModel ?= null

    @Bindable
    var fuelConsumption: Double = 0.0
        set(value) {
            field = value
            notifyPropertyChanged(BR.fuelConsumption)
        }

    @Bindable
    var fuelPrice: Double = 0.0
        set(value) {
            field = value
            notifyPropertyChanged(BR.fuelPrice)
        }

    fun nextStep() {
        when (step) {
            AXIS -> {
                if (numberAxis == null || numberAxis == 0) {
                    statesMutable.postValue(FreightStates.NotReadyToNextStep(MSG_AXIS_NOT_FILLED))
                } else {
                    step = FUEL_PRICE
                    showButtonExit = false
                    statesMutable.postValue(FreightStates.Next(FUEL_PRICE))
                }
            }

            FUEL_PRICE -> {
                if (fuelPrice == null || fuelPrice == 0.0) {
                    statesMutable.postValue(
                        FreightStates.NotReadyToNextStep(
                            MSG_FUEL_PRICE_NOT_FILLED
                        )
                    )
                } else {
                    step = CONSUMPTION
                    statesMutable.postValue(FreightStates.Next(CONSUMPTION))
                }
            }

            CONSUMPTION -> {
                if (fuelConsumption == null || fuelConsumption == 0.0) {
                    statesMutable.postValue(
                        FreightStates.NotReadyToNextStep(
                            MSG_FUEL_CONSUMPTION_NOT_FILLED
                        )
                    )
                } else {
                    step = POINT_START
                    statesMutable.postValue(FreightStates.Next(POINT_START))
                }
            }

            POINT_START -> {
                if (pointStart == null) {
                    statesMutable.postValue(
                        FreightStates.NotReadyToNextStep(
                            MSG_POINT_START_NOT_FILLED
                        )
                    )
                } else {
                    step = POINT_END
                    statesMutable.postValue(FreightStates.Next(POINT_END))
                }
            }

            POINT_END -> {
                if (pointEnd == null) {
                    statesMutable.postValue(
                        FreightStates.NotReadyToNextStep(
                            MSG_POINT_END_NOT_FILLED
                        )
                    )
                } else {
                    step = RESUME
                    if(checkStateNotNull()){
                        showButtonCalc = true
                    }else{
                        showButtonCalc = false
                        showButtonNext = false
                    }

                    statesMutable.postValue(FreightStates.Next(RESUME))
                }
            }

            else -> {
                statesMutable.postValue(null)
            }
        }
    }

    fun backStep() {
        when (step) {
            RESUME -> {
                step = POINT_END
                showButtonCalc = false
                showButtonNext = true
                statesMutable.postValue(FreightStates.Back(POINT_END))
            }

            POINT_END -> {
                step = POINT_START
                statesMutable.postValue(FreightStates.Back(POINT_START))
            }

            POINT_START -> {
                step = CONSUMPTION
                statesMutable.postValue(FreightStates.Back(CONSUMPTION))
            }

            CONSUMPTION -> {
                step = FUEL_PRICE
                statesMutable.postValue(FreightStates.Back(FUEL_PRICE))
            }

            FUEL_PRICE -> {
                step = AXIS
                showButtonExit = true
                statesMutable.postValue(FreightStates.Back(AXIS))
            }

            AXIS -> {
                statesMutable.postValue(FreightStates.Exit)
                //talvez mandar aqui um status para mostrar o botao sair
            }
        }
    }

    private fun checkStateNotNull() : Boolean{
        return numberAxis != 0 && pointStart != null && pointEnd != null && fuelConsumption != 0.0 && fuelPrice != 0.0
    }

}