package com.darioossa.melitest.ui.search

import androidx.lifecycle.ViewModel
import com.darioossa.melitest.ui.search.util.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel: ViewModel() {
    private val _state = MutableStateFlow(ScreenState())
    val state = _state.asStateFlow()

    fun onTextChange(value: String) {
        _state.value = _state.value.copy(text = value)
    }
}