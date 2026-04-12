package com.zappyware.recipebrowser.ui.page.ingredients

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zappyware.recipebrowser.data.IngredientList
import com.zappyware.recipebrowser.ui.composable.IngredientListItem
import com.zappyware.recipebrowser.ui.page.Page
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun Ingredients(
    modifier: Modifier = Modifier,
    viewModel: IngredientsViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val bodyMedium = MaterialTheme.typography.bodyMedium
    val buttonTextStyle = remember(bodyMedium) { bodyMedium.copy(shadow = null) }

    Page(
        modifier = modifier,
        uiState = uiState,
        pageTitle = "Ingredients"
    ) { modifier, data ->
        val ingredients = data as? IngredientList ?: return@Page
        if (ingredients.ingredients.isEmpty()) return@Page

        val listState = rememberLazyListState()

        LazyColumn(
            modifier = modifier
                .safeContentPadding(),
            state = listState,
        ) {
            items(
                count = ingredients.ingredients.size,
                key = { index -> ingredients.ingredients[index].id!! },
            ) { index ->
                val ingredient = ingredients.ingredients[index]
                IngredientListItem(
                    modifier = Modifier.fillMaxWidth(),
                    ingredient = ingredient,
                    buttonTextStyle = buttonTextStyle,
                    onLoadRelatedRecipes = {
                        viewModel.onLoadRelatedRecipes(ingredient)
                    }
                )
            }
        }
    }

    LaunchedEffect(viewModel) {
        viewModel.getIngredients()
    }
}
