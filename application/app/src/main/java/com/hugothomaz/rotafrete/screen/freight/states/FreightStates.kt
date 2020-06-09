package com.hugothomaz.rotafrete.screen.freight.states

import com.hugothomaz.domain.model.FreightModel


sealed class FreightStates() {
    object SuccessCall : FreightStates()
    class Next(val stepPosition : Int) : FreightStates()
    class Back(val stepPosition : Int) : FreightStates()
    class NotReadyToNextStep(val message: String) : FreightStates()
    object NotReadyCalc : FreightStates()
    class Error(val message: String) : FreightStates()
}