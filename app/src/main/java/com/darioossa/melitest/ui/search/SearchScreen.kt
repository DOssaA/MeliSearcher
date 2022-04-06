package com.darioossa.melitest.ui.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.darioossa.melitest.ui.search.components.ScreenContent

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    onSubmit: (text: String) -> Unit
) {
    val state = viewModel.state.collectAsState().value
    ScreenContent(
        searchText = state.text,
        onValueChange = viewModel::onTextChange,
        onSubmit = { onSubmit(state.text) }
    )
}