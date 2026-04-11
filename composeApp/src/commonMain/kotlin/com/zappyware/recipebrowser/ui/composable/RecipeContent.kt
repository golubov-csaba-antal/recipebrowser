package com.zappyware.recipebrowser.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zappyware.recipebrowser.data.Recipe

@Composable
fun RecipeContent(
    modifier: Modifier = Modifier,
    recipe: Recipe?,
) {
    if (null == recipe) {
        Text(
            text = "No recipe found"
        )
    } else {
        Column(
            modifier = modifier,
        ) {
            Text(
                text = recipe.name
            )
        }
    }
}