package com.houston.buy.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    suspend fun getItemList(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItemToList(entity: ProductEntity)

    @Query("DELETE FROM products WHERE id = :id")
    suspend fun removeItemFromList(id: Int)
}
