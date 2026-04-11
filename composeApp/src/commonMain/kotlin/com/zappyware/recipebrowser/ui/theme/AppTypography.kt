package com.zappyware.recipebrowser.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.unit.sp

private val FontShadow = Shadow(
    color = Color.Black,
    offset = Offset(2f, 2f),
    blurRadius = 5f
)

// Set of Material typography styles to start with
val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 32.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.5.sp,
        shadow = FontShadow,
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.5.sp,
        lineBreak = LineBreak.Paragraph,
        hyphens = Hyphens.Auto,
        shadow = FontShadow,
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        shadow = FontShadow,
    ),
)
