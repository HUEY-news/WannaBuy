package com.houston.buy.ui.local

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.houston.buy.databinding.ItemDatabaseProductBinding
import com.houston.buy.domain.model.Data

class ProductLocalAdapter(
    private val onItemClick: (data: Data) -> Unit
) : RecyclerView.Adapter<ProductLocalViewHolder>(){
    private var itemList: List<Data> = emptyList()

    fun submitList(list: List<Data>) {
        val diffCallback = ProductLocalDiffCallback(itemList, list)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        itemList = list
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductLocalViewHolder {
        val layoutInspector = LayoutInflater.from(parent.context)
        return ProductLocalViewHolder(ItemDatabaseProductBinding.inflate(layoutInspector, parent, false))
        { position: Int ->
            if (position != RecyclerView.NO_POSITION) {
                itemList.getOrNull(position)?.let { data: Data ->
                    onItemClick(data)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ProductLocalViewHolder, position: Int) {
        itemList.getOrNull(position)?.let { data: Data -> holder.bind(data) }
    }

    override fun getItemCount(): Int = itemList.size

    fun removeItem(position: Int): Data {
        val item = itemList[position]
        val newList = itemList.filterIndexed { index, _ -> index != position }
        submitList(newList)
        return item
    }
}