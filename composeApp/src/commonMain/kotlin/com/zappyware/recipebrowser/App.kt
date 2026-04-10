package com.zappyware.recipebrowser

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import recipebrowser.composeapp.generated.resources.Res
import recipebrowser.composeapp.generated.resources.compose_multiplatform
import recipebrowser.composeapp.generated.resources.pager_background

@Composable
@Preview
fun App() {
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
                    var showContent by remember { mutableStateOf(false) }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .safeContentPadding(),
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Page $pageIndex",
                            style = MaterialTheme.typography.headlineLarge,
                        )
                        Button(onClick = { showContent = !showContent }) {
                            Text("Click me!")
                        }
                        AnimatedVisibility(showContent) {
                            val greeting = remember { Greeting().greet() }
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Image(painterResource(Res.drawable.compose_multiplatform), null)
                                Text("Compose: $greeting")
                            }
                        }
                    }
                }
            }
        }
    }
}