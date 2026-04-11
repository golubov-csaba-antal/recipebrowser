package com.zappyware.recipebrowser.ui.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
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
        val scrollState = rememberScrollState()
        Column(
            modifier = modifier.verticalScroll(scrollState)
                .safeContentPadding(),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = recipe.name,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "${recipe.category}, ${recipe.origin}",
                style = MaterialTheme.typography.bodySmall
            )
            AsyncImage(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 24.dp)
                    .border(1.dp, Color.DarkGray),
                model = recipe.image,
                contentDescription = recipe.name,
                contentScale = ContentScale.FillWidth,
            )
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 24.dp),
                text = "Ingredients",
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 24.dp),
                text = recipe.ingredients.joinToString("\n") { "\u2022 ${it.name} (${it.measure})" },
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 24.dp),
                text = "Instructions",
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 24.dp),
                text = recipe.instructions,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}