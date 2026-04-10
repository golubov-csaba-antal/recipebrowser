package com.zappyware.recipebrowser

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.zappyware.recipebrowser.ui.composable.Panorama
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
        MaterialTheme(
            colorScheme = darkColorScheme(onSurface = Color.White)
        ) {
            Surface {
                Panorama(
                    modifier = Modifier.fillMaxSize(),
                    pageCount = 8,
                )
            }
        }
    }
}
