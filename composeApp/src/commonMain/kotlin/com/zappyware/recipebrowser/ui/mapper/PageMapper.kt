package com.zappyware.recipebrowser.ui.mapper

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import com.zappyware.recipebrowser.ui.page.default.DefaultPage
import com.zappyware.recipebrowser.ui.page.random.RandomRecipe

class PageMapper {

    @Composable
    fun Map(
        modifier: Modifier,
        pageIndex: Int
    ) {
        when (pageIndex) {
            0 -> RandomRecipe(
                modifier = modifier
            )
            else -> DefaultPage(
                modifier = modifier,
                pageIndex = pageIndex
            )
        }
    }
}

val LocalPageMapper = staticCompositionLocalOf { PageMapper() }
