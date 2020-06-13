package com.hugothomaz.rotafrete.screen.main.state

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.rotafrete.BR

class MainStatesView : BaseObservable(){

    @Bindable
    var isEmpty : Boolean = false
    private set

    @Bindable
    var isShowHistoricCalcFreight : Boolean = false
    set(value) {
        field = value
        checkStateEmpty()
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
        checkStateEmpty()
        notifyPropertyChanged(BR.isShowInsightButton)
    }

    private fun checkStateEmpty(){
        when {
            !isShowHistoricCalcFreight && !isShowInsightButton -> {
                isEmpty = false
            }
            else -> {
                isEmpty = true
            }
        }
        notifyPropertyChanged(BR.isEmpty)
    }

}