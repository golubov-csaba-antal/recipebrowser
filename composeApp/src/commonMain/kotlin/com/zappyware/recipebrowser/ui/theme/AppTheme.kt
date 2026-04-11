package com.zappyware.recipebrowser.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppTheme(
    childComposable: @Composable (() -> Unit)
) {
    MaterialTheme(
        colorScheme = darkColorScheme(onSurface = Color.White),
        typography = AppTypography,
    ) {
        childComposable()
    }
}
