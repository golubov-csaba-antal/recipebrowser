package com.zappyware.recipebrowser.repository

import com.zappyware.recipebrowser.network.Api

class RecipeRepository(
    private val recipeApi: Api
) {
    suspend fun getRandomRecipe() = recipeApi.getRandomRecipe()

    suspend fun getCategories() = recipeApi.getCategories()

    suspend fun getAreas() = recipeApi.getAreas()

    suspend fun getIngredients() = recipeApi.getIngredients()
}
