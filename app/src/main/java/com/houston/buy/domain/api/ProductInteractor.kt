package com.houston.buy.domain.api

import com.houston.buy.domain.model.Product

interface ProductInteractor {
    suspend fun addProduct(product: Product)
    suspend fun removeProduct(product: Product)
}
