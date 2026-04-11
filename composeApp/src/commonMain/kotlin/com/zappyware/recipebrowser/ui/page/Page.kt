package com.zappyware.recipebrowser.ui.page

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zappyware.recipebrowser.ui.UIState

@Composable
fun Page(
    modifier: Modifier = Modifier,
    uiState: UIState,
    pageTitle: String,
    pageContent: @Composable (Modifier, Any?) -> Unit,
) {

    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 24.dp),
            text = pageTitle,
            style = MaterialTheme.typography.headlineLarge,
        )
        AnimatedContent(
            targetState = uiState,
            transitionSpec = {
                fadeIn(
                    animationSpec = tween(300)
                ) togetherWith fadeOut(animationSpec = tween(300))
            },
        ) { uiState ->
            when (uiState) {
                is UIState.Loading -> CircularProgressIndicator(
                    modifier = Modifier
                        .padding(horizontal = 24.dp),
                )
                is UIState.Success<*> -> pageContent(
                    Modifier.fillMaxSize()
                        .padding(horizontal = 24.dp),
                    uiState.data,
                )
                is UIState.Error -> Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp),
                    text = uiState.message
                )
            }
        }
    }
}
