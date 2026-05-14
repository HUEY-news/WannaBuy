package com.houston.buy.ui.compose.components.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.houston.buy.R
import com.houston.buy.ui.compose.components.pages.PageBlank
import com.houston.buy.ui.theme.Theme

@Composable
internal fun ButtonBack(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .border(
                width = 2.dp,
                color = colorResource(R.color.blue_400),
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.icon_back),
            contentDescription = null,
            tint = colorResource(R.color.blue_400)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    Theme {
        PageBlank {
            ButtonBack(
                modifier = Modifier.padding(16.dp),
                onClick = {}
            )
        }
    }
}