package com.zappyware.recipebrowser.ui

import com.zappyware.recipebrowser.data.Recipe

sealed class UIState {
    object Loading: UIState()
    data class Success(val recipes: List<Recipe>): UIState()
    data class Error(val message: String): UIState()
}