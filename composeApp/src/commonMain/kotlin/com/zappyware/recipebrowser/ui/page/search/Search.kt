package com.zappyware.recipebrowser.ui.page.search

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zappyware.recipebrowser.ui.page.Page
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun Search(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Page(
        modifier = modifier,
        uiState = uiState,
        pageTitle = "Search"
    ) { modifier, data ->
        Text(
            modifier = modifier,
            text = data as String,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
