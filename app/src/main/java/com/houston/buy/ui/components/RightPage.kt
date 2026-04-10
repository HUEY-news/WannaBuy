package com.houston.buy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.houston.buy.ui.theme.GridCyan
import com.houston.buy.ui.theme.MarginRed
import com.houston.buy.ui.theme.PaperWhite
import com.houston.buy.ui.theme.Theme

@Composable
fun RightPage(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(PaperWhite)
            .drawBehind {
                val cellSize = 32.dp.toPx()
                val strokeWidth = 4.dp.toPx()

                var x = 0f
                while (x < size.width) {
                    drawLine(
                        color = GridCyan,
                        start = Offset(x, 0f),
                        end = Offset(x, size.height),
                        strokeWidth = strokeWidth
                    )
                    x += cellSize
                }

                var y = 0f
                while (y < size.height) {
                    drawLine(
                        color = GridCyan,
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth
                    )
                    y += cellSize
                }

                val marginX = size.width - (cellSize * 2.5f)
                drawLine(
                    color = MarginRed,
                    start = Offset(marginX, 0f),
                    end = Offset(marginX, size.height),
                    strokeWidth = 2.dp.toPx()
                )
            }
    ) {
        content()
    }
}

@Preview
@Composable
private fun Preview() {
    Theme {
        RightPage {}
    }
}