package com.houston.buy.presentation

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.houston.buy.domain.api.ProductInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class ProductCreationViewModel(
    private val interactor: ProductInteractor
): ViewModel() {

    fun createNewProduct(name: String, description: String?, image: Uri?) {
        viewModelScope.launch {
            interactor.createNewProduct(name, description, image)
        }
    }
}
