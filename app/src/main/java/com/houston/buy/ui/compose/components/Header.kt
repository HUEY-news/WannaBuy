package com.houston.buy.ui.compose.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.houston.buy.R
import com.houston.buy.ui.compose.components.buttons.ButtonBack
import com.houston.buy.ui.compose.components.pages.PageBlank
import com.houston.buy.ui.theme.Theme
import com.houston.buy.ui.theme.Typography

@Composable
internal fun Header(
    modifier: Modifier = Modifier,
    text: String,
    onBackClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ButtonBack(onClick = onBackClick)

        Text(
            text = text,
            style = Typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    Theme {
        PageBlank {
            Header(
                text = stringResource(R.string.header),
                onBackClick = {}
            )
        }
    }
}