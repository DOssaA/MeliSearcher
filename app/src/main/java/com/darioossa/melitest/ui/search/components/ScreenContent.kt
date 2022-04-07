package com.darioossa.melitest.ui.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.darioossa.melitest.R
import com.darioossa.melitest.ui.theme.ElevationDefault
import com.darioossa.melitest.ui.theme.MarginDefault

@Composable
fun ScreenContent(
    searchText: String = "",
    onValueChange: (text: String) -> Unit = {},
    onSubmit: () -> Unit = {}
) {
    Box(modifier = Modifier
        .background(MaterialTheme.colors.primary)
        .fillMaxSize()) {
        Text(text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(MarginDefault))
        Surface(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MarginDefault)
            .align(Alignment.Center)
            .wrapContentHeight(),
            elevation = ElevationDefault
        ) {
            SearchField(searchText, onValueChange, onSubmit)
        }
    }

}

@Preview
@Composable
fun ContentPreview() {
    ScreenContent()
}