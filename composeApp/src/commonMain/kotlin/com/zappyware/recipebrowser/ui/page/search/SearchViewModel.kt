package com.zappyware.recipebrowser.ui.page.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zappyware.recipebrowser.repository.RecipeRepository
import com.zappyware.recipebrowser.ui.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val recipeRepository: RecipeRepository,
): ViewModel() {

    val uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)

    init {
        viewModelScope.launch {
            uiState.emit(UIState.Success("Placeholder Text"))
        }
    }

}
