package com.houston.buy.domain.impl

import android.net.Uri
import com.houston.buy.domain.api.ProductInteractor
import com.houston.buy.domain.api.ProductRepository
import com.houston.buy.domain.model.Product
import kotlinx.coroutines.flow.Flow

class ProductInteractorImpl(
    private val repository: ProductRepository
) : ProductInteractor {

    override fun getProductList(): Flow<List<Product>> {
        return repository.getProductList()
    }

    override suspend fun createNewProduct(name: String, description: String?, image: Uri?) {
        repository.createNewProduct(name, description, image)
    }

    override suspend fun removeProduct(product: Product) {
        repository.removeProduct(product)
    }
}
