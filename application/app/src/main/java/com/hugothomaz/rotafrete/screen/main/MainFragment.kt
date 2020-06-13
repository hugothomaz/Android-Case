package com.hugothomaz.rotafrete.screen.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.rotafrete.databinding.FragmentMainBinding
import com.hugothomaz.rotafrete.screen.main.adapter.FreightAdapter
import com.hugothomaz.rotafrete.screen.main.state.MainStatesAction
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModel<MainViewModel>()
    private var freightAdapter: FreightAdapter? = null

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
        bindList()
        requestListFreight()

    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    private fun requestListFreight(){
        viewModel.requestListFreight()
    }

    private fun setToolbar() {
        (activity as MainActivity).apply {
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(false)
                setHomeButtonEnabled(false)
            }

            getToolbar()?.apply {
                setTitle("Rota Frete")
            }
        }
    }

    private fun bindViewModel() {
        binding.btOpenFreight.setOnClickListener {
            val action = MainFragmentDirections.actionMainToFreight()
            findNavController().navigate(action)
        }
    }

    private fun observableStatesActionViewModel() {
        viewModel.statesAction.observe(this@MainFragment.viewLifecycleOwner, Observer {states ->
            when (states) {
                is MainStatesAction.ListFreights -> {
                    addListFreight(states.listFreight)
                }
                is MainStatesAction.SelectFreight -> {

                }
            }
        })
    }

    private fun addListFreight(listFreight : List<FreightModel>){
        freightAdapter?.addItens(listFreight)
    }

    private fun bindList() {
        val list = binding.recycler
        freightAdapter = FreightAdapter()

        list.apply {
            adapter = freightAdapter
            layoutManager =
                LinearLayoutManager(this.context).apply {
                    orientation = LinearLayoutManager.VERTICAL
                    reverseLayout = true
                    stackFromEnd = true
                }
        }
    }

}