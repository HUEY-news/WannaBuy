package com.houston.buy.ui.local

import androidx.recyclerview.widget.DiffUtil
import com.houston.buy.domain.model.Data

class ProductLocalDiffCallback(
    private val oldList: List<Data>,
    private val newList: List<Data>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

}