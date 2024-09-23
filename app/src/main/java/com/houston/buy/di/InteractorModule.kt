package com.houston.buy.di

import com.houston.buy.domain.api.ProductInteractor
import com.houston.buy.domain.api.ProductRepository
import com.houston.buy.domain.impl.ProductInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class InteractorModule {

    @Provides
    fun provideProductInteractor(repository: ProductRepository): ProductInteractor {
        return ProductInteractorImpl(repository = repository)
    }

}
