package com.darioossa.melitest.ui.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.darioossa.melitest.ui.theme.Gray200
import com.darioossa.melitest.ui.theme.MarginDefault
import com.darioossa.melitest.ui.theme.MarginSmall
import com.darioossa.melitest.ui.theme.MarginTiny
import com.darioossa.melitest.ui.theme.component.BaseContent

@Composable
fun DetailContent(loading: Boolean, detail: SearchResult, goBack: () -> Unit) {
    BaseContent(
        title = stringResource(id = R.string.item_detail),
        loading = loading,
        onGoBack = goBack
    ) {
        Column(modifier = Modifier.padding(MarginDefault)) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                painter = rememberImagePainter(
                    data = detail.pictures?.firstOrNull()?.url ?: detail.thumbnail,
                    builder = {
                        crossfade(true)
                        fallback(R.drawable.ic_launcher_foreground)
                    }
                ),
                contentScale = ContentScale.None,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(MarginDefault))
            Text(text = detail.title, style = MaterialTheme.typography.h2)
            Spacer(modifier = Modifier.height(MarginSmall))
            Text(text = stringResource(id = R.string.price_format)
                .format(detail.price, detail.currency_id),
                style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.height(MarginSmall))
            Text(text = stringResource(id = R.string.tags),
                style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(MarginSmall))
            Column(Modifier.padding(horizontal = MarginTiny)) {
                detail.tags.forEach {
                    Card(backgroundColor = Gray200) {
                        Text(text = it,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.padding(MarginTiny))
                    }
                }
            }
        }
    }
}