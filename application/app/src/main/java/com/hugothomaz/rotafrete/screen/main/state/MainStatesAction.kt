package com.hugothomaz.rotafrete.screen.main.state

import com.hugothomaz.domain.model.FreightModel

sealed class MainStatesAction() {
    class OpenFreight(freightModel : FreightModel) : MainStatesAction()
    class SelectFreight(val freightModel: FreightModel) : MainStatesAction()
    class ListFreights(val listFreight: List<FreightModel>) : MainStatesAction()
    class Error(val message : String) : MainStatesAction()
}