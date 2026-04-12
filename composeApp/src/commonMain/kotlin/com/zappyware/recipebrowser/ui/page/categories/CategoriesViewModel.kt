package com.zappyware.recipebrowser.ui.page.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zappyware.recipebrowser.data.Category
import com.zappyware.recipebrowser.repository.RecipeRepository
import com.zappyware.recipebrowser.ui.UIState
import com.zappyware.recipebrowser.util.orDefaultError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val recipeRepository: RecipeRepository,
): ViewModel() {

    val uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)

    suspend fun getCategories() {
        val response = recipeRepository.getCategories()
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

    fun onLoadRelatedRecipes(category: Category) {
        // todo
    }
}
