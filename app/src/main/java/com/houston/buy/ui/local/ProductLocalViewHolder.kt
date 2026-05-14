package com.houston.buy.ui.local

import androidx.recyclerview.widget.RecyclerView
import com.houston.buy.databinding.ItemDatabaseProductBinding
import com.houston.buy.domain.model.Data
import com.houston.buy.tools.onClick

class ProductLocalViewHolder(
    private val binding: ItemDatabaseProductBinding,
    onItemClick: (position: Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.onClick {
            onItemClick(bindingAdapterPosition)
        }
    }

    fun bind(data: Data) {
        itemView.alpha = 1.0f
        itemView.translationX = 0f
        binding.productName.text = data.name
        binding.productDescription.text = data.description
    }
}