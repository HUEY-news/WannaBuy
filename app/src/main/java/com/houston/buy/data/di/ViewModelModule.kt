package com.houston.buy.data.di

import com.houston.buy.presentation.ProductCreationViewModel
import com.houston.buy.presentation.ProductDatabaseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProductCreationViewModel(interactor = get()) }
    viewModel { ProductDatabaseViewModel(interactor = get()) }
}
