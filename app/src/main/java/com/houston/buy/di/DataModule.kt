package com.houston.buy.di

import android.content.Context
import androidx.room.Room
import com.houston.buy.converter.DatabaseConverter
import com.houston.buy.data.db.ProductDatabase
import com.houston.buy.data.impl.ProductRepositoryImpl
import com.houston.buy.domain.api.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideProductRepository(database: ProductDatabase, converter: DatabaseConverter): ProductRepository {
        return ProductRepositoryImpl(database = database, converter = converter)
    }

    @Provides
    fun provideProductDatabase(@ApplicationContext context: Context): ProductDatabase {
        return Room.databaseBuilder(context, ProductDatabase::class.java, "database.db").build()
    }

    @Provides
    fun provideDatabaseConverter() : DatabaseConverter {
        return DatabaseConverter()
    }

}
