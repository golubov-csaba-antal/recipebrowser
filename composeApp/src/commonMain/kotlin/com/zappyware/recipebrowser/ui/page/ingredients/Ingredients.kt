package com.zappyware.recipebrowser.ui.page.ingredients

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

    Page(
        modifier = modifier,
        uiState = uiState,
        pageTitle = "Ingredients"
    ) { modifier, data ->
        val ingredients = data as? IngredientList ?: return@Page
        if (ingredients.ingredients.isEmpty()) return@Page

        val listState = rememberLazyListState()

        LazyColumn(
            modifier = modifier,
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
                    onLoadRelatedRecipes = {
                        viewModel.onLoadRelatedRecipes(ingredient)
                    }
                )
            }
        }
    }
}
