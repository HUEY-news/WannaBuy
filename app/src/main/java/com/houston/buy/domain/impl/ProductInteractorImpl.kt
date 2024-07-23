package com.houston.buy.domain.impl

import android.net.Uri
import com.houston.buy.domain.api.ProductInteractor
import com.houston.buy.domain.api.ProductRepository
import com.houston.buy.domain.model.Product

class ProductInteractorImpl(
    private val repository: ProductRepository
) : ProductInteractor {

    override suspend fun addProduct(id: String?, name: String, description: String?, image: Uri?) {
        repository.addProduct(id, name, description, image)
    }

    override suspend fun removeProduct(product: Product) {
        repository.removeProduct(product)
    }
}
