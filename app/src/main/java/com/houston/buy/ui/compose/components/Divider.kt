package com.houston.buy.ui.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.houston.buy.R
import com.houston.buy.ui.compose.components.pages.PageBlank
import com.houston.buy.ui.theme.Theme

@Composable
internal fun Divider(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally)
        .width(320.dp)
        .height(2.dp)
        .background(colorResource(R.color.blue_400))
    )
}

@Preview
@Composable
private fun Preview() {
    Theme {
        PageBlank {
            Divider(modifier = Modifier.padding(16.dp))
        }
    }
}