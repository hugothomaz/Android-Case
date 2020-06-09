package com.hugothomaz.rotafrete.screen.freight.states

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import com.hugothomaz.domain.model.PointModel
import com.hugothomaz.rotafrete.BR
import com.hugothomaz.rotafrete.core.SingleLiveEvent

class FreightStatesView : BaseObservable() {

    private val AXIS = 0
    private val FUEL_PRICE = 1
    private val CONSUMPTION = 2
    private val POINT_START = 3
    private val POINT_END = 4
    private val RESUME = 5

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
    var showButtonExit: Boolean = false
        private set(value) {
            field = value
            //checkStateNotNull()
            notifyPropertyChanged(BR.showButtonExit)
        }

    @Bindable
    var numberAxis: Int = 0
        set(value) {
            field = value
            //checkStateNotNull()
            notifyPropertyChanged(BR.numberAxis)
        }

    @Bindable
    var pointStart: PointModel = PointModel(-23.629332,-46.6916186)
        set(value) {
            field = value
            //checkStateNotNull()
            notifyPropertyChanged(BR.pointStart)
        }

    @Bindable
    var pointEnd: PointModel = PointModel(-23.6227534,-46.6714801)
        set(value) {
            field = value
            //checkStateNotNull()
            notifyPropertyChanged(BR.pointEnd)
        }

    @Bindable
    var fuelConsumption: Double = 0.0
        set(value) {
            field = value
            //checkStateNotNull()
            notifyPropertyChanged(BR.fuelConsumption)
        }

    @Bindable
    var fuelPrice: Double = 0.0
        set(value) {
            field = value
            //checkStateNotNull()
            notifyPropertyChanged(BR.fuelPrice)
        }

    fun nextStep() {
        when (step) {
            AXIS -> {
                if (numberAxis == null || numberAxis == 0) {
                    statesMutable.postValue(FreightStates.NotReadyToNextStep(MSG_AXIS_NOT_FILLED))
                } else {
                    step = FUEL_PRICE
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
                statesMutable.postValue(FreightStates.Back(AXIS))
            }

            AXIS -> {
                //talvez mandar aqui um status para mostrar o botao sair
            }
        }
    }

}