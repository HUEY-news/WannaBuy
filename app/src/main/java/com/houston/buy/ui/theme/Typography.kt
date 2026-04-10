package com.houston.buy.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.houston.buy.R

val MisterBrush = FontFamily(
    Font(R.font.font_mister_brush)
)

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = MisterBrush,
        fontSize = 32.sp,
        color = InkBlueDark
    ),
    bodyMedium = TextStyle(
        fontFamily = MisterBrush,
        fontSize = 24.sp,
        color = InkBlueDark
    ),
    labelMedium = TextStyle(
        fontFamily = MisterBrush,
        fontSize = 16.sp,
        color = InkBlueDark
    )
)