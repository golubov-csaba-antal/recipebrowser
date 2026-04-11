package com.zappyware.recipebrowser.network

import com.zappyware.recipebrowser.data.Recipe

data class ApiResponse(
    val recipes: List<Recipe> = emptyList(),
    val error: String? = null,
)
