package com.darioossa.melitest.ui.search

import org.junit.Test

class SearchViewModelTest {

    private var viewModel = SearchViewModel()

    @Test
    fun `handles text change`() {
        viewModel.onTextChange("manzanas")
        assert(viewModel.state.value.text == "manzanas")
        viewModel.onTextChange("echo")
        assert(viewModel.state.value.text == "echo")
    }
}