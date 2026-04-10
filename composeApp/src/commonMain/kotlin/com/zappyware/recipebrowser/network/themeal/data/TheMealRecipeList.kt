package com.zappyware.recipebrowser.network.themeal.data

import com.zappyware.recipebrowser.data.RecipeList
import kotlinx.serialization.Serializable

@Serializable
class TheMealRecipeList(
    val meals: List<TheMealRecipe>,
) {
}

fun TheMealRecipeList.toRecipeList(): RecipeList =
    RecipeList(
        meals.map { it.toRecipe() }
    )
