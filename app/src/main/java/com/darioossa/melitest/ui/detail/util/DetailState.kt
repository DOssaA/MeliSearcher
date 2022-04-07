package com.darioossa.melitest.ui.detail.util

import com.darioossa.melitest.domain.entity.SearchResult

data class DetailState(
    val loading: Boolean = false,
    val detail: SearchResult = SearchResult()
)