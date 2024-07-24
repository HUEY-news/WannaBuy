package com.houston.buy.presentation

import androidx.lifecycle.ViewModel
import com.houston.buy.domain.api.ProductInteractor

class ProductDatabaseViewModel(
    private val interactor: ProductInteractor
): ViewModel()