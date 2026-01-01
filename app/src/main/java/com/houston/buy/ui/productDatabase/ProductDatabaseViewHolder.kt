package com.houston.buy.ui.productDatabase

import androidx.recyclerview.widget.RecyclerView
import com.houston.buy.databinding.ItemDatabaseProductBinding
import com.houston.buy.domain.model.Product
import com.houston.buy.tools.onClick

class ProductDatabaseViewHolder(
    private val binding: ItemDatabaseProductBinding,
    onItemClick: (position: Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.onClick {
            onItemClick(bindingAdapterPosition)
        }
    }

    fun bind(product: Product) {
        itemView.alpha = 1.0f
        itemView.translationX = 0f
        binding.productName.text = product.name
        binding.productDescription.text = product.description
    }
}