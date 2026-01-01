package com.houston.buy.domain.model

data class Product(
    val id: Int = NO_ID,
    val name: String,
    val description: String,
    val image: String?
) {
    companion object {
        private const val NO_ID = 0
    }
}