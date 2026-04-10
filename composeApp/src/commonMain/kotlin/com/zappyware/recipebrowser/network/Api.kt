package com.zappyware.recipebrowser.network

import com.zappyware.recipebrowser.data.Recipe

interface Api {
    suspend fun getRandomRecipe(): Recipe?
}
