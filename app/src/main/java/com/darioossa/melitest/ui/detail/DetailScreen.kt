package com.darioossa.melitest.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.darioossa.melitest.ui.detail.component.DetailContent

@Composable fun DetailScreen(viewModel: DetailViewModel, goBack: () -> Unit) {
    val state = viewModel.state.collectAsState().value
    DetailContent(state.loading, state.detail, goBack)
}