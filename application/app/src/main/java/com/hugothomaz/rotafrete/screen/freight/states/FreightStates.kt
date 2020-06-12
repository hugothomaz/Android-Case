package com.hugothomaz.rotafrete.screen.freight.states

import com.hugothomaz.domain.model.FreightModel


sealed class FreightStates() {
    class SuccessCalc(val freightModel: FreightModel) : FreightStates()
    object Load : FreightStates()
    object ToCalc : FreightStates()
    class Next(val stepPosition : Int) : FreightStates()
    class Back(val stepPosition : Int) : FreightStates()
    object Exit : FreightStates()
    class NotReadyToNextStep(val message: String) : FreightStates()
    class Error(val message: String) : FreightStates()
}