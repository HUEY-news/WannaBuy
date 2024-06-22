package com.houston.buy.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "product_table")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String
)
