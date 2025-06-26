package com.garv.treasuregame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.garv.treasuregame.ui.theme.TreasureGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TreasureGameTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    CaptainGame(modifier = Modifier.padding(innerPadding) )
                }
            }
        }
    }
}

@Composable
fun CaptainGame(modifier: Modifier = Modifier)
{
    val treasuresFound = remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val stormAhead = remember { mutableStateOf("") }
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Treasures Found : ${treasuresFound.value}")
        Text("Current Direction: ${direction.value}")
        Text("${stormAhead.value}")
        Button(onClick = {
            direction.value = "East"
            if(Random.nextBoolean()) {
                treasuresFound.value += 1
                stormAhead.value = "WE FOUND A TREASURE !!!"
            }
            else {
                stormAhead.value = "WE DIDN'T FIND THE TREASURE"
            }
        }) {
            Text("Sail East")
        }

        Button(onClick = {
            direction.value = "West"
            if(Random.nextBoolean()) {
                treasuresFound.value += 1
                stormAhead.value = "WE FOUND A TREASURE !!!"
            }
            else {
                stormAhead.value = "WE DIDN'T FIND THE TREASURE"
            }
        }) {
            Text("Sail West")
        }

        Button(onClick = {
            direction.value = "North"
            if(Random.nextBoolean()) {
                treasuresFound.value += 1
                stormAhead.value = "WE FOUND A TREASURE !!!"
            }
            else {
                stormAhead.value = "WE DIDN'T FIND THE TREASURE"
            }
        }) {
            Text("Sail North")
        }

        Button(onClick = {
            direction.value = "South"
            if(Random.nextBoolean()) {
                treasuresFound.value += 1
                stormAhead.value = "WE FOUND A TREASURE !!!"
            }
            else {
                stormAhead.value = "WE DIDN'T FIND THE TREASURE"
            }
        }) {
            Text("Sail South")
        }
    }
}