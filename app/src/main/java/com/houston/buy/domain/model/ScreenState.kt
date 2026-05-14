package com.houston.buy.domain.model

sealed interface ScreenState {
    object Empty : ScreenState
    data class Content(val list: List<Data>) : ScreenState
}