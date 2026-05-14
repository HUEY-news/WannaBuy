package com.houston.buy.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.houston.buy.R
import com.houston.buy.domain.model.Data
import com.houston.buy.domain.model.ScreenState
import com.houston.buy.presentation.LocalViewModel
import com.houston.buy.ui.compose.components.Divider
import com.houston.buy.ui.compose.components.Header
import com.houston.buy.ui.compose.components.ItemList
import com.houston.buy.ui.compose.components.Placeholder
import com.houston.buy.ui.compose.components.pages.PageBlank
import com.houston.buy.ui.theme.Theme

@Composable
internal fun LocalScreen(
    viewModel: LocalViewModel,
    onBackClick: () -> Unit
) {
    val state by viewModel.screenState.collectAsStateWithLifecycle()

    LocalContent(
        state = state,
        onBackClick = onBackClick
    )
}

@Composable
private fun LocalContent(
    state: ScreenState,
    onBackClick: () -> Unit
) {
    PageBlank {
        Column(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
            Header(text = stringResource(R.string.header), onBackClick = onBackClick)
            Divider()

            Box(modifier = Modifier.weight(1f)) {
                when (state) {
                    is ScreenState.Content -> ItemList(list = state.list)
                    is ScreenState.Empty -> Placeholder()
                }
            }

            Divider(modifier = Modifier.padding(bottom = 16.dp))
        }
    }
}

@Preview(name = "Preview")
@Composable
private fun Content() {
    val name = stringResource(R.string.product_name)
    val description = stringResource(R.string.product_description)

    Theme {
        LocalContent(
            state = ScreenState.Content(
                list = List(8) { index ->
                    Data(
                        id = index + 1,
                        name = name,
                        description = description,
                        image = null
                    )
                }
            ),
            onBackClick = {}
        )
    }
}

@Preview(name = "Preview")
@Composable
private fun Empty() {
    Theme {
        LocalContent(
            state = ScreenState.Empty,
            onBackClick = {}
        )
    }
}