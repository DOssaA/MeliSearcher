package com.darioossa.melitest.ui.theme.component

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable

@Composable
fun BaseContent(
    title: String = "",
    onGoBack: (() -> Unit)? = null,
    loading: Boolean = false,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    content: @Composable () -> Unit = {}
) {
    Scaffold(scaffoldState = scaffoldState, topBar = {
        TopBar(title = title, onGoBack = onGoBack)
    }) {
        if (loading) {
            Loading()
        } else {
            content()
        }
    }
}