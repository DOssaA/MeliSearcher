package com.darioossa.melitest.ui.results.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.rememberImagePainter
import com.darioossa.melitest.R
import com.darioossa.melitest.domain.entity.SearchResult
import com.darioossa.melitest.ui.theme.IconSize
import com.darioossa.melitest.ui.theme.MarginSmall
import com.darioossa.melitest.ui.theme.MarginTiny

@Composable
fun SearchItem(
    content: SearchResult,
    goToDetail: (itemId: String) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { goToDetail(content.id) }
            .padding(bottom = MarginSmall)
    ) {
        Row(Modifier.padding(MarginSmall)) {
            Image(
                modifier = Modifier.size(IconSize),
                painter = rememberImagePainter(
                    data = content.thumbnail,
                    builder = {
                        crossfade(true)
                        fallback(R.drawable.ic_launcher_foreground)
                    }
                ),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(MarginSmall))
            Column {
                Text(text = content.title, style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.width(MarginTiny))
                Text(
                    text = stringResource(id = R.string.price_format)
                        .format(content.price, content.currency_id),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}