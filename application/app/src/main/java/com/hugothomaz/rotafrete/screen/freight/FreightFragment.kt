package com.hugothomaz.rotafrete.screen.freight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import com.hugothomaz.rotafrete.databinding.FragmentFreightBinding
import com.hugothomaz.rotafrete.screen.freight.adapter.FreightStepViewPagerAdapter
import com.hugothomaz.rotafrete.screen.freight.states.FreightStates
import com.hugothomaz.rotafrete.screen.freight.states.FreightStatesView
import com.hugothomaz.rotafrete.screen.freight.steps.FragmentFuelPrice
import com.hugothomaz.rotafrete.screen.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class FreightFragment : Fragment() {

    private lateinit var binding: FragmentFreightBinding
    private val viewModel by sharedViewModel<FreightViewModel>()
    private var viewPager: ViewPagerFreight? = null
    private var navController: NavController? = null

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
        setHasOptionsMenu(true)
        bindViewPager()
        bindViewModel()
        observableViewModel()
        bindClick()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val action = FreightFragmentDirections.freightToMain()
                navController?.navigate(action)
                return true
            }
        }
        return false
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
        navController = NavHostFragment.findNavController(this)
    }

    private fun bindViewModel() {
        binding.viewModel = viewModel
    }

    private fun observableViewModel() {
        viewModel.statesView.states.observe(this@FreightFragment.viewLifecycleOwner, Observer {
            handlerStatus(it)
        })
        viewModel.states.observe(this@FreightFragment.viewLifecycleOwner, Observer {
            handlerStatus(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    private fun bindViewPager() {
        val indicator = binding.pageStepper
        viewPager = binding.viewPagerFreight
        viewPager?.let {
            it.adapter = FreightStepViewPagerAdapter(childFragmentManager)
            indicator.setupWithViewPager(it)
        }
    }

    private fun handlerStatus(states: FreightStates?) {
        when (states) {
            is FreightStates.Next -> {
                if (states.stepPosition == FreightStatesView.CONSUMPTION) {
                    viewPager?.let {
                        val fragment = (it.adapter as FreightStepViewPagerAdapter).getFragment(
                            FreightStatesView.FUEL_PRICE
                        ) as FragmentFuelPrice
                        fragment.getListenerSaveFuelPrice().onSaveFuelPrice()
                    }
                }
                viewPager?.currentItem = states.stepPosition
            }
            is FreightStates.Back -> {
                viewPager?.currentItem = states.stepPosition
            }
            is FreightStates.Exit -> {
                navController?.popBackStack()
            }
            is FreightStates.NotReadyToNextStep -> {
                showMessage(states.message)
            }
        }
    }

    private fun bindClick(){
        binding.btCalc.setOnClickListener {
            val action = FreightFragmentDirections.actionFreightToCalcResultFreight(0L)
            navController?.navigate(action)
        }
    }

    private fun showMessage(message: String, isIndefinite: Boolean = false) {
        activity?.let {
            val snack = Snackbar.make(
                it.findViewById(android.R.id.content),
                message,
                Snackbar.LENGTH_INDEFINITE
            )

            if (isIndefinite) {
                snack.setAction("OK") {
                    snack.dismiss()
                }
            } else {
                snack.duration = Snackbar.LENGTH_LONG
            }
            snack.show()
        }
    }

    private fun setToolbar() {
        (activity as MainActivity).apply {
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setHomeButtonEnabled(true)
            }

            getToolbar()?.apply {
                setTitle("Calculo do Frete")
            }
        }
    }

}