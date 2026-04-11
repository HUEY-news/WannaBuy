package com.houston.buy.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.houston.buy.R

val MisterBrush = FontFamily(
    Font(R.font.font_mister_brush)
)

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = MisterBrush,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        color = InkBlue400
    ),
    bodyMedium = TextStyle(
        fontFamily = MisterBrush,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = InkBlue400
    ),
    labelMedium = TextStyle(
        fontFamily = MisterBrush,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = InkBlue200
    )
)