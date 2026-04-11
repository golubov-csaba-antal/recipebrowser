package com.zappyware.recipebrowser.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
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
import com.zappyware.recipebrowser.ui.mapper.LocalPageMapper
import com.zappyware.recipebrowser.ui.mapper.PageMapper
import com.zappyware.recipebrowser.ui.page.Pages
import org.jetbrains.compose.resources.painterResource
import recipebrowser.composeapp.generated.resources.Res
import recipebrowser.composeapp.generated.resources.pager_background

private const val BackgroundImageWidth = 3845f
private const val BackgroundImageHeight = 1090f
private const val TitleParallelScrollOffset = 0.75f

@Composable
fun Panorama(
    modifier: Modifier = Modifier,
    pages: List<Pages>,
    pageMapper: PageMapper = LocalPageMapper.current,
) {
    val localWindow = LocalWindowInfo.current
    val containerWidth = localWindow.containerDpSize.width
    val containerHeight = localWindow.containerDpSize.height
    val pageWidth = remember(containerWidth) { (containerWidth.value * 0.9f).dp }
    val pagerState = rememberPagerState { pages.size }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopStart,
    ) {
        Image(
            modifier = Modifier.height(containerHeight)
                .requiredWidth((containerHeight.value / BackgroundImageHeight * BackgroundImageWidth).dp)
                .graphicsLayer {
                    /**
                     * We need to calculate with the default behavior of requiredWidth:
                     * "..., and the position of the content will be automatically
                     * offset to be centered on the space assigned to the child by
                     * the parent layout under the assumption that Constraints were
                     * respected."
                     *
                     * So if we want to display the start side of the image
                     * at the start side of the screen, we need to shift
                     * the translationX by the half of the image's width
                     * minus the half of the parent's width.
                     *
                     * Then we can add the HorizontalPager scroll position percentage
                     * (page + page offset, where 100% means the last page)
                     * and translate the image by that percentage.
                     *
                     * so translateX = (fixed start offset) + (scroll percentage * image width)
                     */
                    translationX = ((size.width - containerWidth.toPx()) / 2f) + (-(pagerState.currentPage + pagerState.currentPageOffsetFraction) / pages.size * BackgroundImageWidth)
                },
            painter = painterResource(Res.drawable.pager_background),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.TopStart,
            alpha = 0.50f,
        )
        Text(
            modifier = Modifier
                .requiredWidth(720.dp)
                .padding(top = 48.dp, start = 24.dp)
                .graphicsLayer {
                    /**
                     * Same in english
                     *
                     * Except one thing: the title text should scroll by a given offset
                     * to make it look like the good old parallel scrolling.
                     *
                     * We don't have to calculate with the image's width, just do the
                     * page scroll with a given constant offset, and we're good.
                     */
                    translationX = ((size.width - containerWidth.toPx()) / 2f) + (-(pagerState.currentPage + pagerState.currentPageOffsetFraction) * pageWidth.toPx() * TitleParallelScrollOffset)
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
                    .fillMaxSize(),
                page = pages[pageIndex]
            )
        }
    }
}
