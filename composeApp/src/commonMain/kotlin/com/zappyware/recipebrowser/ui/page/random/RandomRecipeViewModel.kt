package com.zappyware.recipebrowser.ui.page.random

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zappyware.recipebrowser.repository.RecipeRepository
import com.zappyware.recipebrowser.ui.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RandomRecipeViewModel(
    private val recipeRepository: RecipeRepository,
): ViewModel() {

    val uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)

    init {
        viewModelScope.launch {
            getRandomRecipe()
        }
    }

    suspend fun getRandomRecipe() {
        val response = recipeRepository.getRandomRecipe()
        if (response.error.isNullOrEmpty()) {
            uiState.emit(
                UIState.Success(response.recipes)
            )
        } else {
            uiState.emit(
                UIState.Error(response.error)
            )
        }
    }
}
