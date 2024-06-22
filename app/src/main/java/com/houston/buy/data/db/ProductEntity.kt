package com.houston.buy.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String,
    val description: String
)
