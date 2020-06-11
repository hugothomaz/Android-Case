package com.hugothomaz.rotafrete.screen.freight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hugothomaz.rotafrete.R
import com.hugothomaz.rotafrete.databinding.FragmentResultCalcFreightBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ResultCalcFreightFragment : Fragment(R.layout.fragment_result_calc_freight) {

    private lateinit var binding: FragmentResultCalcFreightBinding
    private val viewModel by sharedViewModel<FreightViewModel>()


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

    }



}