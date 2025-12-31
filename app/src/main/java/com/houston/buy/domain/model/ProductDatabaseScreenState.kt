package com.houston.buy.domain.model

sealed interface ProductDatabaseScreenState {
    object Empty : ProductDatabaseScreenState
    data class Content(val data: List<Product>) : ProductDatabaseScreenState
}