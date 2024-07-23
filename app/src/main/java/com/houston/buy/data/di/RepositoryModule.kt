package com.houston.buy.data.di

import com.houston.buy.data.impl.ProductRepositoryImpl
import com.houston.buy.domain.api.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(database = get(), converter = get()) }
}
