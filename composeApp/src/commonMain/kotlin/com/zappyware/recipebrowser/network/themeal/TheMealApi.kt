package com.zappyware.recipebrowser.network.themeal

import com.zappyware.recipebrowser.data.AreaList
import com.zappyware.recipebrowser.data.CategoryList
import com.zappyware.recipebrowser.data.IngredientList
import com.zappyware.recipebrowser.data.RecipeList
import com.zappyware.recipebrowser.network.Api
import com.zappyware.recipebrowser.network.ApiResponse
import com.zappyware.recipebrowser.network.themeal.data.TheMealAreaList
import com.zappyware.recipebrowser.network.themeal.data.TheMealCategoryList
import com.zappyware.recipebrowser.network.themeal.data.TheMealIngredientList
import com.zappyware.recipebrowser.network.themeal.data.TheMealRecipeList
import com.zappyware.recipebrowser.network.themeal.data.toAreaList
import com.zappyware.recipebrowser.network.themeal.data.toCategoryList
import com.zappyware.recipebrowser.network.themeal.data.toIngredientList
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

    override suspend fun getRandomRecipe(): ApiResponse<RecipeList> =
        withContext(Dispatchers.Default) {
            val response = httpClient.get(TheMealDb.RandomRecipe)
            if (response.status.value in 200..299) {
                ApiResponse(
                    data = response.body<TheMealRecipeList>()
                        .toRecipeList(),
                )
            } else {
                ApiResponse(
                    error = response.bodyAsText(),
                )
            }
        }

    override suspend fun getCategories(): ApiResponse<CategoryList> =
        withContext(Dispatchers.Default) {
            val response = httpClient.get(TheMealDb.Categories)
            if (response.status.value in 200..299) {
                ApiResponse(
                    data = response.body<TheMealCategoryList>()
                        .toCategoryList(),
                )
            } else {
                ApiResponse(
                    error = response.bodyAsText(),
                )
            }
        }

    override suspend fun getAreas(): ApiResponse<AreaList> =
        withContext(Dispatchers.Default) {
            val response = httpClient.get(TheMealDb.Areas)
            if (response.status.value in 200..299) {
                ApiResponse(
                    data = response.body<TheMealAreaList>()
                        .toAreaList(),
                )
            } else {
                ApiResponse(
                    error = response.bodyAsText(),
                )
            }
        }

    override suspend fun getIngredients(): ApiResponse<IngredientList> =
        withContext(Dispatchers.Default) {
            val response = httpClient.get(TheMealDb.Ingredients)
            if (response.status.value in 200..299) {
                ApiResponse(
                    data = response.body<TheMealIngredientList>()
                        .toIngredientList(),
                )
            } else {
                ApiResponse(
                    error = response.bodyAsText(),
                )
            }
        }
}
