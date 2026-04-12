package com.zappyware.recipebrowser.ui.page.ingredients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zappyware.recipebrowser.data.Ingredient
import com.zappyware.recipebrowser.repository.RecipeRepository
import com.zappyware.recipebrowser.ui.UIState
import com.zappyware.recipebrowser.util.orDefaultError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class IngredientsViewModel(
    private val recipeRepository: RecipeRepository,
): ViewModel() {

    val uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)

    suspend fun getIngredients() {
        val response = recipeRepository.getIngredients()
        if (null == response.data) {
            uiState.emit(
                UIState.Error(response.error.orDefaultError())
            )
        } else {
            uiState.emit(
                UIState.Success(response.data)
            )
        }
    }

    fun onLoadRelatedRecipes(category: Ingredient) {
        // todo
    }
}
