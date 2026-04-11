package com.zappyware.recipebrowser.ui.mapper

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import com.zappyware.recipebrowser.ui.page.Pages
import com.zappyware.recipebrowser.ui.page.areas.Areas
import com.zappyware.recipebrowser.ui.page.browse.Browse
import com.zappyware.recipebrowser.ui.page.categories.Categories
import com.zappyware.recipebrowser.ui.page.ingredients.Ingredients
import com.zappyware.recipebrowser.ui.page.random.RandomRecipe
import com.zappyware.recipebrowser.ui.page.search.Search

class PageMapper {

    @Composable
    fun Map(
        modifier: Modifier,
        page: Pages
    ) {
        when (page) {
            Pages.RandomRecipe -> RandomRecipe(
                modifier = modifier,
            )
            Pages.Categories -> Categories(
                modifier = modifier,
            )
            Pages.Areas -> Areas(
                modifier = modifier,
            )
            Pages.Ingredients -> Ingredients(
                modifier = modifier,
            )
            Pages.Search -> Search(
                modifier = modifier,
            )
            Pages.Browser -> Browse(
                modifier = modifier,
            )
        }
    }
}

val LocalPageMapper = staticCompositionLocalOf { PageMapper() }
