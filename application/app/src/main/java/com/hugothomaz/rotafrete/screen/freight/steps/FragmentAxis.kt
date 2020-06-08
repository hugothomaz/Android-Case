package com.hugothomaz.rotafrete.screen.freight.steps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hugothomaz.rotafrete.R
import com.hugothomaz.rotafrete.databinding.StepAxisFragmentBinding
import com.hugothomaz.rotafrete.screen.freight.FreightViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentAxis : Fragment(R.layout.step_axis_fragment) {


    private val viewModel by viewModel<FreightViewModel>()
    private lateinit var bind : StepAxisFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = StepAxisFragmentBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun bindViewModel(){
        bind.viewModel = viewModel
    }



}