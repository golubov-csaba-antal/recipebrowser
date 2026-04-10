package com.zappyware.recipebrowser.ui.page.random

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zappyware.recipebrowser.Greeting
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import recipebrowser.composeapp.generated.resources.Res
import recipebrowser.composeapp.generated.resources.compose_multiplatform

@Composable
fun RandomRecipe(
    modifier: Modifier = Modifier,
    viewModel: RandomRecipeViewModel = koinViewModel()
) {
    val recipe by viewModel.recipe.collectAsStateWithLifecycle()

    var showContent by remember { mutableStateOf(false) }
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = recipe?.name ?: "Page Random Recipe",
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