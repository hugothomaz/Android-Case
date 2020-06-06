package com.hugothomaz.rotafrete.screen.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.hugothomaz.rotafrete.databinding.FragmentMainBinding
import com.hugothomaz.rotafrete.screen.main.state.MainStatesAction
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        observableStatesActionViewModel()
    }

    private fun bindViewModel() {
        binding.viewModel = viewModel
    }

    private fun observableStatesActionViewModel() {
        viewModel.statesAction.observe(this@MainFragment.viewLifecycleOwner, Observer {
            when (it) {
                is MainStatesAction.OpenFreight -> {
                    val action = MainFragmentDirections.actionMainToFreight()
                    findNavController().navigate(action)
                }
                is MainStatesAction.SelectFreight -> {
                }
            }
        })
    }


}