package com.houston.buy.presentation

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.houston.buy.domain.api.ProductInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductCreationViewModel @Inject constructor(
    private val interactor: ProductInteractor
): ViewModel() {

    fun createNewProduct(name: String, description: String, image: Uri?) {
        viewModelScope.launch {
            interactor.createNewProduct(name, description, image)
        }
    }
}
