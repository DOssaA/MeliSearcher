package com.darioossa.melitest.ui.search.util

sealed class SearchEvent {
    data class ShowResults(val input: String): SearchEvent()
}