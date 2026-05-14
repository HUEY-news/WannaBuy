package com.houston.buy.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Entity::class])
abstract class Database : RoomDatabase() {
    abstract fun dao(): Dao
}