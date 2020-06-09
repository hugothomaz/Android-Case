package com.hugothomaz.rotafrete.screen.freight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.hugothomaz.rotafrete.databinding.FragmentFreightBinding
import com.hugothomaz.rotafrete.screen.freight.adapter.FreightStepViewPagerAdapter
import com.hugothomaz.rotafrete.screen.freight.states.FreightStates
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

        /*viewModel.setPoints(Pair(-23.6238397,-46.6966189), Pair(-23.582421,-46.6396582))
        viewModel.setAxis(2)
        viewModel.setFuelConsumption(4.6)
        viewModel.setFuelPrice(2.5)
        viewModel.calcFreight()*/
    }

    private fun bindViewModel() {
        binding.viewModel =
            viewModel //la tratar, criar algum binding para fazer algo quando mover a tela, para mover a tela

        viewModel.statesView.states.observe(this@FreightFragment.viewLifecycleOwner, Observer {
            handlerStatus(it)
        })
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