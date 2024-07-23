package com.houston.buy.data.di

import com.houston.buy.presentation.AddingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AddingViewModel(interactor = get()) }
}
