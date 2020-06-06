package com.hugothomaz.rotafrete.screen.main.state

import com.hugothomaz.domain.model.FreightModel

sealed class MainStatesAction() {
    object OpenFreight : MainStatesAction()
    class SelectFreight(val freightModel: FreightModel) : MainStatesAction()
}