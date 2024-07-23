package com.houston.buy.presentation

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.houston.buy.domain.api.ProductInteractor
import kotlinx.coroutines.launch

class AddingViewModel(
    private val interactor: ProductInteractor
): ViewModel() {

    fun createNewProduct(name: String, description: String?, image: Uri?) {
        viewModelScope.launch {
            interactor.addProduct(name, description, image)
        }
    }
}
