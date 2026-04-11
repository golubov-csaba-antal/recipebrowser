package com.zappyware.recipebrowser.network.themeal

import com.zappyware.recipebrowser.network.Api
import com.zappyware.recipebrowser.network.ApiResponse
import com.zappyware.recipebrowser.network.themeal.data.TheMealRecipeList
import com.zappyware.recipebrowser.network.themeal.data.toRecipeList
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Though ktor runs requests on the IO thread, JSON mapping and
 * object mapping should not happen on the UI thread even,
 * hence I will use withContext(Dispatchers.Default) in the functions.
 *
 * A custom plugin would be awesome too, but not sure whether
 * ContentNegotiation runs JSON parsing on the default thread.
 */
class TheMealApi(
    private val httpClient: HttpClient,
): Api {

    override suspend fun getRandomRecipe(): ApiResponse =
        withContext(Dispatchers.Default) {
            val response = httpClient.get(TheMealDb.RandomRecipe)
            if (response.status.value in 200..299) {
                ApiResponse(
                    recipes = response.body<TheMealRecipeList>()
                        .toRecipeList()
                        .recipes
                )
            } else {
                ApiResponse(
                    error = response.bodyAsText()
                )
            }
        }
}
