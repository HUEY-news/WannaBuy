package com.houston.buy.di

import com.houston.buy.domain.api.LocalInteractor
import com.houston.buy.domain.api.LocalRepository
import com.houston.buy.domain.impl.LocalInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideLocalInteractor(repository: LocalRepository): LocalInteractor {
        return LocalInteractorImpl(repository = repository)
    }
}
