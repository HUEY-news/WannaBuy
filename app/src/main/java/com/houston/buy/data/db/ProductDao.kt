package com.houston.buy.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(entity: ProductEntity)

    @Delete
    suspend fun removeProduct(entity: ProductEntity)
}
