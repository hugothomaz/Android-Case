package com.hugothomaz.rotafrete.screen.freight.steps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hugothomaz.domain.model.enums.OperationPointEnum
import com.hugothomaz.rotafrete.R
import com.hugothomaz.rotafrete.databinding.StepAxisFragmentBinding
import com.hugothomaz.rotafrete.databinding.StepResumeFragmentBinding
import com.hugothomaz.rotafrete.screen.freight.FreightViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentResume : Fragment(R.layout.step_resume_fragment){

    private val viewModel by sharedViewModel<FreightViewModel>()
    private lateinit var bind : StepResumeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = StepResumeFragmentBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        bindFragmentStartPoint()
        bindFragmentEndPoint()
    }

    private fun bindViewModel(){
        bind.viewModel = viewModel
    }

    private fun bindFragmentStartPoint(){
        val fragmentStratPoint : FragmentPoint = FragmentPoint(OperationPointEnum.OPERATION_START_RESUME)
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val view = bind.pointStartMap

        fragmentTransaction.add(view.id, fragmentStratPoint)
        fragmentTransaction.commit()
    }

    private fun bindFragmentEndPoint(){
        val fragmentStratPoint : FragmentPoint = FragmentPoint(OperationPointEnum.OPERATION_END_RESUME)
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val view = bind.pointEndMap

        fragmentTransaction.add(view.id, fragmentStratPoint)
        fragmentTransaction.commit()
    }

}