package com.garv.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.garv.navigationsample.ui.theme.NavigationSampleTheme

@Composable
fun SecondScreen(paddingValues: PaddingValues,name: String, NavigateToFirstScreen: (String) -> Unit) {

    Column(modifier = Modifier.padding(paddingValues).fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("This is the Second screen", fontSize = 24.sp)
        Text("Welcome $name", fontSize = 24.sp)
        Button(onClick = {
            NavigateToFirstScreen(name)
        }) {
            Text("Go to the First screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
        //SecondScreen(paddingValues = PaddingValues())
}