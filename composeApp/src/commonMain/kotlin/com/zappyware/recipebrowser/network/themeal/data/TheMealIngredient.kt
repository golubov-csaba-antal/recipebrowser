package com.zappyware.recipebrowser.network.themeal.data

import com.zappyware.recipebrowser.data.Ingredient
import kotlinx.serialization.Serializable

@Serializable
data class TheMealIngredient(
    val idIngredient: String,
    val strIngredient: String,
    val strDescription: String?,
    val strThumb: String,
)

fun TheMealIngredient.toIngredient(): Ingredient {
    return Ingredient(
        id = idIngredient,
        name = strIngredient.trim(),
        description = strDescription?.trim(),
        image = strThumb.trim(),
    )
}
