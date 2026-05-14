package com.houston.buy.domain.impl

import android.net.Uri
import com.houston.buy.domain.api.LocalInteractor
import com.houston.buy.domain.api.LocalRepository
import com.houston.buy.domain.model.Data
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalInteractorImpl @Inject constructor(
    private val repository: LocalRepository
) : LocalInteractor {

    override fun getProductList(): Flow<List<Data>> {
        return repository.getProductList()
    }

    override suspend fun createNewProduct(name: String, description: String, image: Uri?) {
        repository.createNewProduct(name, description, image)
    }

    override suspend fun removeProduct(id: Int) {
        repository.removeProduct(id)
    }
}