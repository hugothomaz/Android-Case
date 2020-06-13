package com.hugothomaz.rotafrete.screen.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.rotafrete.R
import com.hugothomaz.rotafrete.databinding.ItemFreightBinding

class FreightAdapter : RecyclerView.Adapter<FreightAdapter.FreightViewHolder>() {

    private val list: ArrayList<FreightModel> = arrayListOf()

    private var selectFreightListener: SelectFreightListener? = null

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FreightViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FreightViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_freight, parent, false
        ) as ItemFreightBinding

        return FreightViewHolder(itemBinding = binding)
    }

    fun addItens(listItens: List<FreightModel>) {
        list.clear()
        list.addAll(listItens)

        notifyDataSetChanged()
    }

    fun addSelectFreightListener(selectFreightListener: SelectFreightListener) {
        this.selectFreightListener = selectFreightListener
    }

    inner class FreightViewHolder(val itemBinding: ItemFreightBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(model: FreightModel) {
            itemBinding.apply {
                root.setOnClickListener {
                    selectFreightListener?.selectFreightModel(model)
                }
                freightModel = model
                executePendingBindings()
            }
        }
    }

    interface SelectFreightListener {
        fun selectFreightModel(freightModel: FreightModel)
    }

}