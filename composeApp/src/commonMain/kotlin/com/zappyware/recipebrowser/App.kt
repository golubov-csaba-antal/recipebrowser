package com.zappyware.recipebrowser

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zappyware.recipebrowser.ui.page.default.DefaultPage
import com.zappyware.recipebrowser.ui.page.random.RandomRecipe
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.KoinApplication
import org.koin.dsl.koinConfiguration
import recipebrowser.composeapp.generated.resources.Res
import recipebrowser.composeapp.generated.resources.pager_background

@Composable
@Preview
fun App() {
    KoinApplication(
        configuration = koinConfiguration {
            modules(KoinModules)
        }
    ) {
        MaterialTheme(
            colorScheme = darkColorScheme(onSurface = Color.White)
        ) {
            Surface {
                val localWindow = LocalWindowInfo.current
                val pageWidth = remember { (localWindow.containerDpSize.width.value * 0.9f).dp }
                val pagerState = rememberPagerState { 8 }
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Image(
                        modifier = Modifier.fillMaxHeight()
                            .requiredWidth((pagerState.pageCount * pageWidth.value).dp)
                            .graphicsLayer {
                                translationX = -(pagerState.currentPage + pagerState.currentPageOffsetFraction) * pageWidth.value
                            },
                        painter = painterResource(Res.drawable.pager_background),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight,
                        alignment = Alignment.TopStart,
                        alpha = 0.75f,
                    )
                    HorizontalPager(
                        modifier = Modifier.fillMaxSize(),
                        state = pagerState,
                        pageSize = PageSize.Fixed(pageWidth)
                    ) { pageIndex ->
                        when (pageIndex) {
                            0 -> RandomRecipe(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .safeContentPadding(),
                            )
                            else -> DefaultPage(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .safeContentPadding(),
                                pageIndex = pageIndex,
                            )
                        }
                    }
                }
            }
        }
    }
}