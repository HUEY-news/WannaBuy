package com.houston.buy.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.houston.buy.domain.api.LocalInteractor
import com.houston.buy.domain.model.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocalViewModel @Inject constructor(
    private val interactor: LocalInteractor
) : ViewModel() {

    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Empty)
    val screenState: StateFlow<ScreenState> = _screenState.asStateFlow()
    private fun renderState(state: ScreenState) { _screenState.value = state }

    init { updateScreenState() }
    fun onResume() { updateScreenState() }

    private fun updateScreenState() {
        viewModelScope.launch {
            interactor
                .getProductList()
                .collect { list ->
                    if (list.isEmpty()) renderState(ScreenState.Empty)
                    else renderState(ScreenState.Content(list))
                }
        }
    }

    fun removeProduct(id: Int) {
        viewModelScope.launch {
            interactor.removeProduct(id)
        }
    }
}