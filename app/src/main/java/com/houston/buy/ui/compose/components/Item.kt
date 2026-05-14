package com.houston.buy.ui.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.houston.buy.R
import com.houston.buy.domain.model.Data
import com.houston.buy.ui.compose.components.pages.PageBlank
import com.houston.buy.ui.theme.InkBlue200
import com.houston.buy.ui.theme.Theme
import com.houston.buy.ui.theme.Typography

@Composable
internal fun Item(
    modifier: Modifier = Modifier,
    data: Data
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(2.dp, InkBlue200, RoundedCornerShape(16.dp))
        ) {
            if (data.image != null) {
                AsyncImage(
                    model = data.image,
                    contentDescription = data.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.placeholder_product_image),
                    contentDescription = stringResource(R.string.product_image),
                    modifier = Modifier.fillMaxSize().padding(12.dp),
                    alpha = 0.5f
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = data.name,
                style = Typography.bodyMedium
            )
            if (data.description.isNotEmpty()) {
                Text(
                    text = data.description,
                    style = Typography.labelMedium
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    Theme {
        PageBlank {
            Item(
                data = Data(
                    name = stringResource(R.string.product_name),
                    description = stringResource(R.string.product_description),
                    image = null
                )
            )
        }
    }
}