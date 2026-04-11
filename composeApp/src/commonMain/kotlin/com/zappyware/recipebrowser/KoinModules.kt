package com.zappyware.recipebrowser

import com.zappyware.recipebrowser.network.Api
import com.zappyware.recipebrowser.network.themeal.TheMealApi
import com.zappyware.recipebrowser.repository.RecipeRepository
import com.zappyware.recipebrowser.ui.page.areas.AreasViewModel
import com.zappyware.recipebrowser.ui.page.browse.BrowseViewModel
import com.zappyware.recipebrowser.ui.page.categories.CategoriesViewModel
import com.zappyware.recipebrowser.ui.page.ingredients.IngredientsViewModel
import com.zappyware.recipebrowser.ui.page.random.RandomRecipeViewModel
import com.zappyware.recipebrowser.ui.page.search.SearchViewModel
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
    viewModelOf(::CategoriesViewModel)
    viewModelOf(::AreasViewModel)
    viewModelOf(::IngredientsViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::BrowseViewModel)
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
