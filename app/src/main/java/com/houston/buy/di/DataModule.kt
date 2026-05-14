package com.houston.buy.di

import android.content.Context
import androidx.room.Room
import com.houston.buy.converter.Converter
import com.houston.buy.data.db.Database
import com.houston.buy.data.impl.LocalRepositoryImpl
import com.houston.buy.domain.api.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideLocalRepository(database: Database, converter: Converter): LocalRepository {
        return LocalRepositoryImpl(database = database, converter = converter)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, "database.db").build()
    }

    @Provides
    fun provideConverter() : Converter {
        return Converter()
    }
}