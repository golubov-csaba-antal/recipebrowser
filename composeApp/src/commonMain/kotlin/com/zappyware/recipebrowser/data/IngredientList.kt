package com.zappyware.recipebrowser.data

import kotlinx.serialization.Serializable

@Serializable
data class IngredientList(
    val ingredients: List<Ingredient>,
)
