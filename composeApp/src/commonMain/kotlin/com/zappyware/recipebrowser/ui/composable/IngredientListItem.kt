package com.zappyware.recipebrowser.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.zappyware.recipebrowser.data.Ingredient

@Composable
fun IngredientListItem(
    modifier: Modifier = Modifier,
    ingredient: Ingredient,
    onLoadRelatedRecipes: () -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 24.dp),
            text = ingredient.name,
            style = MaterialTheme.typography.bodyLarge,
        )
        ingredient.description?.let { description ->
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = description,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 24.dp),
            shape = RectangleShape,
            onClick = {
                onLoadRelatedRecipes()
            },
        ) {
            Text(
                text = "View all related recipes",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
