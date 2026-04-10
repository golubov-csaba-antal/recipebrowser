package com.zappyware.recipebrowser.ui.page.random

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zappyware.recipebrowser.data.Recipe
import com.zappyware.recipebrowser.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RandomRecipeViewModel(
    private val recipeRepository: RecipeRepository,
): ViewModel() {

    val recipe: MutableStateFlow<Recipe?> = MutableStateFlow(null)

    init {
        viewModelScope.launch {
            getRandomRecipe()
        }
    }

    suspend fun getRandomRecipe() {
        recipe.emit(
            recipeRepository.getRandomRecipe()
        )
    }
}
