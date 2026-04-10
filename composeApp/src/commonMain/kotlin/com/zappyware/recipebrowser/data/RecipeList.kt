package com.zappyware.recipebrowser.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeList(
    @SerialName("meals")
    val recipes: List<Recipe>,
)
