package com.houston.buy.di

import com.houston.buy.converter.DatabaseConverter
import com.houston.buy.data.db.ProductDatabase
import com.houston.buy.data.impl.ProductRepositoryImpl
import com.houston.buy.domain.api.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(database: ProductDatabase, converter: DatabaseConverter): ProductRepository {
        return ProductRepositoryImpl(database = database, converter = converter)
    }

}
