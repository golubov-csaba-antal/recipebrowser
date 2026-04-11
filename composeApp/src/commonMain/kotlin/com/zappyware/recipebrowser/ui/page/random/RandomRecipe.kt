package com.zappyware.recipebrowser.ui.page.random

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zappyware.recipebrowser.ui.UIState
import com.zappyware.recipebrowser.ui.composable.RecipeContent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RandomRecipe(
    modifier: Modifier = Modifier,
    viewModel: RandomRecipeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Recommended recipe",
            style = MaterialTheme.typography.headlineLarge,
        )
        AnimatedContent(
            targetState = uiState,
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(300)
                ) togetherWith fadeOut(animationSpec = tween(300))
            },
        ) { uiState ->
            when (uiState) {
                is UIState.Loading -> CircularProgressIndicator(
                    modifier = Modifier,
                )
                is UIState.Success -> RecipeContent(
                    modifier = Modifier.fillMaxSize(),
                    recipe = uiState.recipes.firstOrNull(),
                )
                is UIState.Error -> Text(
                    text = uiState.message
                )
            }
        }
    }
}
