package com.hugothomaz.rotafrete.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hugothomaz.rotafrete.core.SingleLiveEvent
import com.hugothomaz.rotafrete.screen.main.state.MainStatesAction
import com.hugothomaz.rotafrete.screen.main.state.MainStatesView


class MainViewModel() : ViewModel() {

    var statesView = MainStatesView()
    private set

    private val statesActionMutable = SingleLiveEvent<MainStatesAction>()
    val statesAction : LiveData<MainStatesAction>
    get() = statesActionMutable

    fun openFreight(){
        statesActionMutable.postValue(MainStatesAction.OpenFreight)
    }

}