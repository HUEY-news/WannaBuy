package com.houston.buy.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [ProductEntity::class])
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}