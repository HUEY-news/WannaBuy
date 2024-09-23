package com.houston.buy.di

import android.content.Context
import androidx.room.Room
import com.houston.buy.converter.DatabaseConverter
import com.houston.buy.data.db.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideProductDatabase(@ApplicationContext context: Context): ProductDatabase {
        return Room.databaseBuilder(context, ProductDatabase::class.java, "database.db").build()
    }

    @Provides
    @Singleton
    fun provideDatabaseConverter() : DatabaseConverter {
        return DatabaseConverter()
    }

}
