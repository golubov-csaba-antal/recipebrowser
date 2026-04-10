package com.zappyware.recipebrowser.repository

import com.zappyware.recipebrowser.network.Api

class RecipeRepository(
    private val recipeApi: Api
) {
    suspend fun getRandomRecipe() = recipeApi.getRandomRecipe()
}
