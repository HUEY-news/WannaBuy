package com.houston.buy.domain.api

import android.net.Uri
import com.houston.buy.domain.model.Product

interface ProductInteractor {
    suspend fun createNewProduct(name: String, description: String?, image: Uri?)
    suspend fun removeProduct(product: Product)
}
