package com.houston.buy.data.di

import com.houston.buy.domain.api.ProductInteractor
import com.houston.buy.domain.impl.ProductInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<ProductInteractor> { ProductInteractorImpl(repository = get()) }
}
