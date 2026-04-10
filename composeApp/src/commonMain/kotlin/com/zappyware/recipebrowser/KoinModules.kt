package com.zappyware.recipebrowser

import com.zappyware.recipebrowser.network.Api
import com.zappyware.recipebrowser.network.themeal.TheMealApi
import com.zappyware.recipebrowser.repository.RecipeRepository
import com.zappyware.recipebrowser.ui.page.random.RandomRecipeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val KoinModules = module {
    single { buildClient() }
    single { TheMealApi(get()) } bind Api::class

    singleOf(::RecipeRepository)
    viewModelOf(::RandomRecipeViewModel)
}

private fun buildClient() =
    HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }
