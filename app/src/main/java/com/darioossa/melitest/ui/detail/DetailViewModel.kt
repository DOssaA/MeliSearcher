package com.darioossa.melitest.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darioossa.melitest.domain.GetDetailUseCase
import com.darioossa.melitest.domain.extensions.isSuccess
import com.darioossa.melitest.domain.extensions.successData
import com.darioossa.melitest.ui.detail.util.DetailState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val itemId: String,
    private val getDetail: GetDetailUseCase
): ViewModel() {

    private val _state = MutableStateFlow(DetailState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            getDetail(itemId).apply {
                if (isSuccess) {
                    _state.value = _state.value.copy(detail = successData)
                }
                _state.value = _state.value.copy(loading = false)
            }
        }
    }

}