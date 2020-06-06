package com.hugothomaz.rotafrete.screen.main.state

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.rotafrete.BR

class MainStatesView : BaseObservable(){

    @Bindable
    var isEmpty : Boolean = false
    private set(value){
        when {
            !isShowHistoricCalcFreight && !isShowInsightButton -> {
                field = false
            }
            else -> {
                field = true
            }
        }
        notifyPropertyChanged(BR.isEmpty)
    }

    @Bindable
    var isShowHistoricCalcFreight : Boolean = false
    set(value) {
        field = value
        notifyPropertyChanged(BR.isShowHistoricCalcFreight)
    }

    @Bindable
    var historicFreight : List<FreightModel> = arrayListOf()
    set(value) {
        field = value
        notifyPropertyChanged(BR.historicFreight)
    }

    @Bindable
    var isShowInsightButton : Boolean = false
    set(value) {
        field = value
        notifyPropertyChanged(BR.isShowInsightButton)
    }

}