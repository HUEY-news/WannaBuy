package com.houston.buy.domain.impl

import com.houston.buy.domain.api.ProductInteractor
import com.houston.buy.domain.api.ProductRepository
import com.houston.buy.domain.model.Product

class ProductInteractorImpl(
    private val repository: ProductRepository
) : ProductInteractor {

    override suspend fun addProduct(product: Product) {
        repository.addProduct(product)
    }

    override suspend fun removeProduct(product: Product) {
        repository.removeProduct(product)
    }
}
