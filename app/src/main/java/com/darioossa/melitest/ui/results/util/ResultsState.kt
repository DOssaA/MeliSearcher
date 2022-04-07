package com.darioossa.melitest.ui.results.util

import com.darioossa.melitest.domain.entity.SearchResult

data class ResultsState(
    val loading: Boolean = false,
    val content: List<SearchResult> = listOf()
)