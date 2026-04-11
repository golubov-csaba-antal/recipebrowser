package com.zappyware.recipebrowser.ui.page.areas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zappyware.recipebrowser.data.Area
import com.zappyware.recipebrowser.repository.RecipeRepository
import com.zappyware.recipebrowser.ui.UIState
import com.zappyware.recipebrowser.util.orDefaultError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AreasViewModel(
    private val recipeRepository: RecipeRepository,
): ViewModel() {

    val uiState: MutableStateFlow<UIState> = MutableStateFlow(UIState.Loading)

    init {
        viewModelScope.launch {
            getAreas()
        }
    }

    private suspend fun getAreas() {
        val response = recipeRepository.getAreas()
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

    fun onLoadRelatedRecipes(category: Area) {
        // todo
    }
}
