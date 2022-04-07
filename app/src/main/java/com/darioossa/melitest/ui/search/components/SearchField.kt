package com.darioossa.melitest.ui.search.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.darioossa.melitest.R

@Composable fun SearchField(
    searchText: String = "",
    onValueChange: (text: String) -> Unit = {},
    onSubmit: () -> Unit = {}
) {
    TextField(
        value = searchText,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = stringResource(R.string.search_placeholder))
        },
        trailingIcon = {
            IconButton(onClick = onSubmit) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                )
            }
        },
        maxLines = 1,
        shape = MaterialTheme.shapes.large,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSubmit() }),
        singleLine = true
    )
}