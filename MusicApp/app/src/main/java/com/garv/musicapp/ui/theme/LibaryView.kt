package com.garv.musicapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.garv.musicapp.Lib
import com.garv.musicapp.libraries

@Composable
fun Library() {
    LazyColumn() {
        items(libraries) {
            lib ->
            LibItem(lib = lib)
        }
    }
}


@Composable
fun LibItem(lib: Lib) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().height(64.dp).padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(lib.icon),
                    contentDescription = lib.name,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Text(lib.name)
            }
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = lib.name)
        }
        Divider(color = Color.Gray)
    }
}