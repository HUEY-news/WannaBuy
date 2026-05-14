package com.houston.buy.ui.compose.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.houston.buy.R
import com.houston.buy.domain.model.Data
import com.houston.buy.ui.compose.components.pages.PageBlank
import com.houston.buy.ui.theme.Theme

@Composable
fun ItemList(
    modifier: Modifier = Modifier,
    list: List<Data>
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(items = list, key = { it.id }) {
            Item(data = it)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val name = stringResource(R.string.product_name)
    val description = stringResource(R.string.product_description)

    Theme {
        PageBlank {
            ItemList(list = List(9) { index ->
                Data(
                    id = index + 1,
                    name = name,
                    description = description,
                    image = null
                )
            })
        }
    }
}