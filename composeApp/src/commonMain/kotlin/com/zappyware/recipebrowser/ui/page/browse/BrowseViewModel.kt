package com.zappyware.recipebrowser.ui.page.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zappyware.recipebrowser.repository.RecipeRepository
import com.zappyware.recipebrowser.ui.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BrowseViewModel(
    private val recipeRepository: RecipeRepository,
): ViewModel() {

    val uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)

    init {
        viewModelScope.launch {
            val alphabet = ('A'..'Z').toList()
            uiState.emit(UIState.Success(alphabet))
        }
    }

    fun onLoadRelatedRecipes(letter: Char) {
        // todo
    }
}
