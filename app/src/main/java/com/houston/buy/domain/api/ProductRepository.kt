package com.houston.buy.domain.api

import android.net.Uri
import com.houston.buy.domain.model.Product

interface ProductRepository {
    suspend fun addProduct(name: String, description: String?, image: Uri?)
    suspend fun removeProduct(product: Product)
}
