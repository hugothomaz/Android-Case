package com.hugothomaz.rotafrete.screen.freight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.hugothomaz.rotafrete.R
import com.hugothomaz.rotafrete.databinding.FragmentResultCalcFreightBinding
import com.hugothomaz.rotafrete.screen.freight.states.FreightStates
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ResultCalcFreightFragment : Fragment(R.layout.fragment_result_calc_freight) {

    private lateinit var binding: FragmentResultCalcFreightBinding
    private val viewModel by sharedViewModel<FreightViewModel>()
    private var freightID = 0L

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultCalcFreightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgument()
        initCalc()
        observableViewModel()
        bindClick()

    }

    private fun initCalc(){
        viewModel.calcFreight(freightID)
    }

    private fun observableViewModel(){
        viewModel.states.observe(this@ResultCalcFreightFragment.viewLifecycleOwner, Observer {
            handlerStates(it)
        })
    }

    private fun handlerStates(states : FreightStates){
        when(states){
            is FreightStates.Load -> {
                binding.isLoading = true
            }
            is FreightStates.SuccessCalc -> {
                binding.isLoading = false
                binding.freightModel = states.freightModel
            }

            is FreightStates.Error -> {
                binding.isLoading = false
            }
        }
    }

    private fun bindClick() {
        binding.includeResultCalc.btFinish.setOnClickListener {
            val action = ResultCalcFreightFragmentDirections.actionResultCalcFreightToMain()
            findNavController()?.navigate(action)
        }
    }

    private fun getArgument(){
        val id = arguments?.get("id_freight")
        if(id != null){
            freightID = (id as Long)
        }
    }

}