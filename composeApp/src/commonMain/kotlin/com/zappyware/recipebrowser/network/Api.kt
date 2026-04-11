package com.zappyware.recipebrowser.network

import com.zappyware.recipebrowser.data.AreaList
import com.zappyware.recipebrowser.data.CategoryList
import com.zappyware.recipebrowser.data.IngredientList
import com.zappyware.recipebrowser.data.RecipeList

interface Api {
    suspend fun getRandomRecipe(): ApiResponse<RecipeList>
    suspend fun getCategories(): ApiResponse<CategoryList>
    suspend fun getAreas(): ApiResponse<AreaList>
    suspend fun getIngredients(): ApiResponse<IngredientList>
}
