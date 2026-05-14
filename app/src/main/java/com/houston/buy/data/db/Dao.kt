package com.houston.buy.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {

    @Query("SELECT * FROM products")
    suspend fun getItemList(): List<Entity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entity: Entity)

    @Query("DELETE FROM products WHERE id = :id")
    suspend fun delete(id: Int)
}
