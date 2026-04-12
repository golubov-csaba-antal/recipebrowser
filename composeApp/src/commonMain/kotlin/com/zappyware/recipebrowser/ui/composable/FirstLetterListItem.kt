package com.zappyware.recipebrowser.ui.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstLetterListItem(
    modifier: Modifier = Modifier,
    letter: Char,
    onLoadRelatedRecipes: () -> Unit,
) {
    Text(
        modifier = modifier
            .border(1.dp, MaterialTheme.colorScheme.outline)
            .clickable(true) {
                onLoadRelatedRecipes()
            }
                .padding(16.dp),
        text = "$letter",
        fontSize = 48.sp,
        fontWeight = FontWeight.Thin,
        style = MaterialTheme.typography.bodyLarge,
    )
}
