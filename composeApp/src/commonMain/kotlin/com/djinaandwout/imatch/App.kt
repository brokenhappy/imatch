package com.djinaandwout.imatch

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import imatch.composeapp.generated.resources.Res
import imatch.composeapp.generated.resources._1_apple
import org.jetbrains.compose.resources.Resource

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable._1_apple), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}

data class Card(/** Always eight */ val images: List<ImatchImage>)
data class ImatchImage(
    val xCenter: Double,
    val yCenter: Double,
    val rotation: Double,
    val maxWidthAndHeight: Double,
    val resource: Resource,
)

fun ImatchImage.matches(other: ImatchImage): Boolean =
    resource == other.resource

/** Always 55 */
fun getDeck(): List<Card> = TODO("Wout will do this")

@Composable
fun ImatchImageCard(card: Card) {

}
