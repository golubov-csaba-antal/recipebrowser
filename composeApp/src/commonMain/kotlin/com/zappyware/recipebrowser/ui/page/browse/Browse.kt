package com.zappyware.recipebrowser.ui.page.browse

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zappyware.recipebrowser.ui.page.Page
import org.koin.compose.viewmodel.koinViewModel

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
        Text(
            modifier = modifier,
            text = data as String,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
