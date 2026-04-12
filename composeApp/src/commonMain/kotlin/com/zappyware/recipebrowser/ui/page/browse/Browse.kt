package com.zappyware.recipebrowser.ui.page.browse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zappyware.recipebrowser.ui.composable.FirstLetterListItem
import com.zappyware.recipebrowser.ui.page.Page
import org.koin.compose.viewmodel.koinViewModel

private val GridSize = 128.dp

@Composable
fun Browse(
    modifier: Modifier = Modifier,
    viewModel: BrowseViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Page(
        modifier = modifier,
        uiState = uiState,
        pageTitle = "Browse"
    ) { modifier, data ->
        val alphabet = data as? List<Char> ?: return@Page
        if (alphabet.isEmpty()) return@Page

        val listState = rememberLazyGridState()

        LazyVerticalGrid(
            modifier = modifier
                .safeContentPadding(),
            state = listState,
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(64.dp),
            verticalArrangement = Arrangement.spacedBy(64.dp),
        ) {
            items(
                count = alphabet.size,
                key = { index -> alphabet[index] },
            ) { index ->
                val letter = alphabet[index]
                FirstLetterListItem(
                    modifier = Modifier
                        .size(GridSize),
                    letter = letter,
                    onLoadRelatedRecipes = {
                        viewModel.onLoadRelatedRecipes(letter)
                    }
                )
            }
        }
    }
}
