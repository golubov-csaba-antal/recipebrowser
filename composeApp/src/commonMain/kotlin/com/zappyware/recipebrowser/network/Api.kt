package com.zappyware.recipebrowser.network

interface Api {
    suspend fun getRandomRecipe(): ApiResponse
}
