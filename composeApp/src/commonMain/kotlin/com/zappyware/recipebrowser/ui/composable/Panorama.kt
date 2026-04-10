package com.zappyware.recipebrowser.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.util.DebugLogger
import com.zappyware.recipebrowser.ui.mapper.LocalPageMapper
import com.zappyware.recipebrowser.ui.mapper.PageMapper
import org.jetbrains.compose.resources.painterResource
import org.koin.core.logger.Logger
import recipebrowser.composeapp.generated.resources.Res
import recipebrowser.composeapp.generated.resources.pager_background

@Composable
fun Panorama(
    modifier: Modifier = Modifier,
    pageCount: Int,
    pageMapper: PageMapper = LocalPageMapper.current,
) {
    val localWindow = LocalWindowInfo.current
    val containerWidth = localWindow.containerDpSize.width
    val containerHeight = localWindow.containerDpSize.height
    val pageWidth = remember(containerWidth) { (containerWidth.value * 0.9f).dp }
    val pagerState = rememberPagerState { pageCount }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopStart,
    ) {
        Image(
            modifier = Modifier.height(containerHeight)
                .requiredWidth((containerHeight.value / 1090f * 3845f).dp)
                .align(Alignment.TopStart)
                .graphicsLayer {
                    translationX = (size.width - containerWidth.toPx()) / 2f + (-(pagerState.currentPage + pagerState.currentPageOffsetFraction) / pageCount * 3845f)
                },
            painter = painterResource(Res.drawable.pager_background),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.TopStart,
            alpha = 0.70f,
        )
        Text(
            modifier = Modifier
                .requiredWidth(720.dp)
                .padding(top = 48.dp, start = 24.dp)
                .graphicsLayer {
                    translationX = (size.width - containerWidth.toPx()) / 2f + (-(pagerState.currentPage + pagerState.currentPageOffsetFraction) * pageWidth.toPx() * 0.75f)
                },
            text = "Recipe Browser",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.displayLarge,
            fontSize = 96.sp,
            fontWeight = FontWeight.Thin,
            maxLines = 1,
            softWrap = false,
        )
        HorizontalPager(
            modifier = Modifier.padding(top = 160.dp)
                .fillMaxSize(),
            state = pagerState,
            pageSize = PageSize.Fixed(pageWidth)
        ) { pageIndex ->
            pageMapper.Map(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                pageIndex = pageIndex
            )
        }
    }
}
