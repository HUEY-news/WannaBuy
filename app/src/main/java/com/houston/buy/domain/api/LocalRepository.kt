package com.houston.buy.domain.api

import android.net.Uri
import com.houston.buy.domain.model.Data
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    fun getProductList(): Flow<List<Data>>
    suspend fun createNewProduct(name: String, description: String, image: Uri?)
    suspend fun removeProduct(id: Int)
}
