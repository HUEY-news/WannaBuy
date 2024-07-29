package com.houston.buy.ui.productDatabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.houston.buy.databinding.ItemDatabaseProductBinding
import com.houston.buy.domain.model.Product

class ProductDatabaseAdapter(
    private val onItemClick: (product: Product) -> Unit
) : RecyclerView.Adapter<ProductDatabaseViewHolder>(){
    private val itemList = mutableListOf<Product>()

    fun setItems(items: List<Product>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDatabaseViewHolder {
        val layoutInspector = LayoutInflater.from(parent.context)
        return ProductDatabaseViewHolder(ItemDatabaseProductBinding.inflate(layoutInspector, parent, false))
        { position: Int ->
            if (position != RecyclerView.NO_POSITION) {
                itemList.getOrNull(position)?.let { product: Product ->
                    onItemClick(product)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ProductDatabaseViewHolder, position: Int) {
        itemList.getOrNull(position)?.let { product: Product ->
            holder.bind(product)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
