package com.zappyware.recipebrowser.ui.page.areas

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zappyware.recipebrowser.data.AreaList
import com.zappyware.recipebrowser.ui.composable.AreaListItem
import com.zappyware.recipebrowser.ui.page.Page
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun Areas(
    modifier: Modifier = Modifier,
    viewModel: AreasViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    
    val bodyMedium = MaterialTheme.typography.bodyMedium
    val buttonTextStyle = remember(bodyMedium) { bodyMedium.copy(shadow = null) }

    Page(
        modifier = modifier,
        uiState = uiState,
        pageTitle = "Areas"
    ) { pageModifier, data ->
        val areas = data as? AreaList ?: return@Page
        if (areas.areas.isEmpty()) return@Page

        val listState = rememberLazyListState()

        LazyColumn(
            modifier = pageModifier
                .safeContentPadding(),
            state = listState,
        ) {
            items(
                count = areas.areas.size,
                key = { index -> areas.areas[index].name },
            ) { index ->
                val area = areas.areas[index]
                AreaListItem(
                    modifier = Modifier.fillMaxWidth(),
                    area = area,
                    buttonTextStyle = buttonTextStyle,
                    onLoadRelatedRecipes = {
                        viewModel.onLoadRelatedRecipes(area)
                    }
                )
            }
        }
    }

    LaunchedEffect(viewModel) {
        viewModel.getAreas()
    }
}
