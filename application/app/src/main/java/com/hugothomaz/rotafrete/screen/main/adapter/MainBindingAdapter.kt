package com.hugothomaz.rotafrete.screen.main.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hugothomaz.rotafrete.screen.main.MainViewModel

object MainBindingAdapter {

    @BindingAdapter(value = ["bindViewModelToRecyclerAdapter"], requireAll = false)
    fun bindViewModelToRecyclerAdapter(
        recyclerView: RecyclerView,
        viewModel: MainViewModel
    ) {
        val adapter = recyclerView.adapter as FreightAdapter
        adapter.setViewModel(viewModel)
    }

}