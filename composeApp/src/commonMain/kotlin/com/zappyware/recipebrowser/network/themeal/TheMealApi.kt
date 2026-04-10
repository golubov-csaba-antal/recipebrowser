package com.zappyware.recipebrowser.network.themeal

import com.zappyware.recipebrowser.data.Recipe
import com.zappyware.recipebrowser.network.Api
import com.zappyware.recipebrowser.network.themeal.data.TheMealRecipeList
import com.zappyware.recipebrowser.network.themeal.data.toRecipe
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TheMealApi(
    private val httpClient: HttpClient,
): Api {

    override suspend fun getRandomRecipe(): Recipe? {
        val recipe = httpClient.get("https://www.themealdb.com/api/json/v1/1/random.php").body<TheMealRecipeList>().meals.firstOrNull()
        return recipe?.toRecipe()
    }
}
