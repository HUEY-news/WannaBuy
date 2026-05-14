package com.houston.buy.ui.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.houston.buy.R
import com.houston.buy.ui.compose.components.pages.PageBlank
import com.houston.buy.ui.theme.InkBlue400
import com.houston.buy.ui.theme.Theme
import com.houston.buy.ui.theme.Typography

@Composable
internal fun Placeholder(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.placeholder_empty_list),
            contentDescription = stringResource(R.string.placeholder_empty_list),
            colorFilter = ColorFilter.tint(InkBlue400)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.placeholder_empty_list),
            style = Typography.titleMedium
        )
    }
}

@Preview
@Composable
private fun Preview() {
    Theme {
        PageBlank {
            Placeholder()
        }
    }
}