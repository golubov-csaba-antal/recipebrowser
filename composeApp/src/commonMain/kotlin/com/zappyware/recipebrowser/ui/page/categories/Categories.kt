package com.zappyware.recipebrowser.ui.page.categories

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
import com.zappyware.recipebrowser.data.CategoryList
import com.zappyware.recipebrowser.ui.composable.CategoryListItem
import com.zappyware.recipebrowser.ui.page.Page
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun Categories(
    modifier: Modifier = Modifier,
    viewModel: CategoriesViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val bodyMedium = MaterialTheme.typography.bodyMedium
    val buttonTextStyle = remember(bodyMedium) { bodyMedium.copy(shadow = null) }

    Page(
        modifier = modifier,
        uiState = uiState,
        pageTitle = "Categories"
    ) { modifier, data ->
        val categories = data as? CategoryList ?: return@Page
        if (categories.categories.isEmpty()) return@Page

        val listState = rememberLazyListState()

        LazyColumn(
            modifier = modifier
                .safeContentPadding(),
            state = listState,
        ) {
            items(
                count = categories.categories.size,
                key = { index -> categories.categories[index].id },
            ) { index ->
                val category = categories.categories[index]
                CategoryListItem(
                    modifier = Modifier.fillMaxWidth(),
                    category = category,
                    buttonTextStyle = buttonTextStyle,
                    onLoadRelatedRecipes = {
                        viewModel.onLoadRelatedRecipes(category)
                    }
                )
            }
        }
    }

    LaunchedEffect(viewModel) {
        viewModel.getCategories()
    }
}
