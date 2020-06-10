package com.hugothomaz.rotafrete.screen.freight

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.hugothomaz.rotafrete.databinding.FragmentFreightBinding
import com.hugothomaz.rotafrete.screen.freight.adapter.FreightStepViewPagerAdapter
import com.hugothomaz.rotafrete.screen.freight.states.FreightStates
import com.hugothomaz.rotafrete.screen.freight.states.FreightStatesView
import com.hugothomaz.rotafrete.screen.freight.steps.FragmentFuelPrice
import com.hugothomaz.rotafrete.screen.freight.steps.ListenerSaveFuelPrice
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class FreightFragment : Fragment() {

    private lateinit var binding: FragmentFreightBinding
    private val viewModel by sharedViewModel<FreightViewModel>()

    private var viewPager: ViewPagerFreight? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFreightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewPager()
        bindViewModel()
    }

    private fun bindViewModel() {
        binding.viewModel =
            viewModel //la tratar, criar algum binding para fazer algo quando mover a tela, para mover a tela

        viewModel.statesView.states.observe(this@FreightFragment.viewLifecycleOwner, Observer {
            handlerStatus(it)
        })
    }

    override fun onPause() {
        super.onPause()
        Log.d("freight_fragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("freight_fragment", "onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("freight_fragment", "onDestroy")
    }

    private fun bindViewPager() {
        val indicator = binding.pageStepper
        viewPager = binding.viewPagerFreight
        viewPager?.let{
            it.adapter = FreightStepViewPagerAdapter(childFragmentManager)
            indicator.setupWithViewPager(it)
        }
    }

    private fun handlerStatus(states: FreightStates?) {
        when (states) {
            is FreightStates.Next -> {
                if(states.stepPosition == FreightStatesView.CONSUMPTION){
                    viewPager?.let {
                        val fragment = (it.adapter as FreightStepViewPagerAdapter).getFragment(FreightStatesView.FUEL_PRICE) as FragmentFuelPrice
                        fragment.getListenerSaveFuelPrice().onSaveFuelPrice()
                    }
                }
                viewPager?.currentItem = states.stepPosition
            }
            is FreightStates.Back -> {
                viewPager?.currentItem = states.stepPosition
            }
            is FreightStates.NotReadyToNextStep -> {
            }
            is FreightStates.Error -> {
            }

        }
    }

}