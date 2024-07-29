package com.houston.buy.di

import androidx.room.Room
import com.houston.buy.converter.DatabaseConverter
import com.houston.buy.data.db.ProductDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { Room.databaseBuilder(androidContext(), ProductDatabase::class.java, "database.db").build() }
    single { DatabaseConverter() }
}
