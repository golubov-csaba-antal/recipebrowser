package com.zappyware.recipebrowser.network.themeal.data

import com.zappyware.recipebrowser.data.IngredientList
import kotlinx.serialization.Serializable

@Serializable
data class TheMealIngredientList(
    val meals: List<TheMealIngredient>,
)

fun TheMealIngredientList.toIngredientList(): IngredientList {
    return IngredientList(
        ingredients = meals.map { it.toIngredient() }
    )
}
