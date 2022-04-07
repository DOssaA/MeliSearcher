package com.darioossa.melitest.ui.results

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.darioossa.melitest.ui.results.components.ResultsContent

@Composable
fun ResultsScreen(
    viewModel: ResultsViewModel,
    searchTerm: String = "",
    goBack: () -> Unit = {},
    goToDetail: (itemId: String) -> Unit = {}
) {
    val state = viewModel.state.collectAsState().value
    ResultsContent(state.loading, searchTerm, state.content, goBack, goToDetail)
}