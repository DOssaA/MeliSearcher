package com.darioossa.melitest.ui.results.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.darioossa.melitest.R
import com.darioossa.melitest.domain.entity.SearchResult
import com.darioossa.melitest.ui.theme.MarginDefault
import com.darioossa.melitest.ui.theme.component.BaseContent

@Composable
fun ResultsContent(
    loading: Boolean = false,
    searchTerm: String = "",
    content: List<SearchResult> = listOf(),
    onGoBack: () -> Unit = {},
    goToDetail: (itemId: String) -> Unit = {},
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    BaseContent(
        title = stringResource(R.string.results_title, searchTerm),
        onGoBack = onGoBack,
        loading = loading
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(MarginDefault)) {
            items(content) { result ->
                SearchItem(result, goToDetail)
            }
        }
    }
}

@Preview
@Composable
fun PreviewContent() {
    ResultsContent()
}