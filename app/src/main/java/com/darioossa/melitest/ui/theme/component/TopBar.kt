package com.darioossa.melitest.ui.theme.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun TopBar(
    title: String = "",
    onGoBack: (() -> Unit)? = null
) {
    TopAppBar(title = {
        Text(text = title, style = MaterialTheme.typography.h2)
    }, navigationIcon = {
        if (onGoBack != null)
            IconButton(onClick = onGoBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Atras",
                    tint = MaterialTheme.typography.h2.color
                )
            }
    })
}