package com.houston.buy.ui.productDatabase

import androidx.recyclerview.widget.RecyclerView
import com.houston.buy.databinding.ItemDatabaseProductBinding
import com.houston.buy.domain.model.Product

class ProductDatabaseViewHolder(
    private val binding: ItemDatabaseProductBinding,
    onItemClick: (position: Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }

    fun bind(product: Product) {
        binding.productName.text = product.name
        binding.productDescription.text = product.description
    }
}
