package com.darioossa.melitest.ui.results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darioossa.melitest.domain.SearchTextUseCase
import com.darioossa.melitest.domain.extensions.isSuccess
import com.darioossa.melitest.domain.extensions.successData
import com.darioossa.melitest.ui.results.util.ResultsState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ResultsViewModel(
    private val text: String,
    private val searchText: SearchTextUseCase
): ViewModel() {

    private val _state = MutableStateFlow(ResultsState())
    val state = _state.asStateFlow()
    private var searchJob: Job? = null

    init {
        startSearch()
    }

    private fun startSearch() {
        searchJob?.cancel()
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            searchText(text).apply {
                when {
                    isSuccess -> searchJob = successData.onEach {
                        _state.value = _state.value.copy(content = it)
                    }.launchIn(viewModelScope)
                    else -> Unit //handle error
                }
                _state.value = _state.value.copy(loading = false)
            }
        }
    }
}