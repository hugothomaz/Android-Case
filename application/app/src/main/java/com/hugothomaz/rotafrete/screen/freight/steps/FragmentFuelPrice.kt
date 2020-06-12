package com.hugothomaz.rotafrete.screen.freight.steps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.hugothomaz.rotafrete.R
import com.hugothomaz.rotafrete.databinding.StepFuelPriceFragmentBinding
import com.hugothomaz.domain.extensions.removeSymbolMoney
import com.hugothomaz.rotafrete.screen.freight.FreightViewModel
import com.hugothomaz.rotafrete.screen.freight.adapter.MoneyTextWatcher
import com.hugothomaz.rotafrete.screen.freight.states.FreightStates
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FragmentFuelPrice : Fragment(R.layout.step_fuel_price_fragment),
    ListenerSaveFuelPrice {

    private val viewModel by sharedViewModel<FreightViewModel>()
    private lateinit var bind: StepFuelPriceFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = StepFuelPriceFragmentBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()

        bindTextWatcherFuelPrice()
    }

    override fun onSaveFuelPrice() {
        viewModel.statesView.fuelPrice =
            bind.tvFuelPrice.text.toString()
                .removeSymbolMoney()
                .toDouble() / 100
    }

    fun getListenerSaveFuelPrice() : ListenerSaveFuelPrice{
        return this
    }

    private fun bindViewModel() {
        bind.viewModel = viewModel
    }

    private fun bindTextWatcherFuelPrice() {
        bind.tvFuelPrice.apply {
            addTextChangedListener(MoneyTextWatcher(this))
        }
    }

}

interface ListenerSaveFuelPrice {
    fun onSaveFuelPrice()
}