package com.zappyware.recipebrowser

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zappyware.recipebrowser.ui.composable.Panorama
import com.zappyware.recipebrowser.ui.page.Pages
import com.zappyware.recipebrowser.ui.theme.AppTheme
import org.koin.compose.KoinApplication
import org.koin.dsl.koinConfiguration

@Composable
@Preview
fun App() {
    KoinApplication(
        configuration = koinConfiguration {
            modules(KoinModules)
        }
    ) {
        val pages = remember {
            listOf(
                Pages.RandomRecipe,
                Pages.Categories,
                Pages.Areas,
                Pages.Ingredients,
                Pages.Search,
                Pages.Browser,
            )
        }
        AppTheme {
            Surface {
                Panorama(
                    modifier = Modifier.fillMaxSize(),
                    pages = pages,
                )
            }
        }
    }
}
