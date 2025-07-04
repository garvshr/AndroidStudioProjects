package com.garv.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.garv.navigationsample.ui.theme.NavigationSampleTheme


@Composable
fun FirstScreen(paddingValues: PaddingValues, NavigateToSecondScreen:(String) -> Unit) {
    val name = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(paddingValues).fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("This is the first screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = {name.value = it})
        Button(onClick = {
            NavigateToSecondScreen(name.value)
        }) {
            Text("Go to the second screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstPreview() {
        //FirstScreen(paddingValues = PaddingValues())
}