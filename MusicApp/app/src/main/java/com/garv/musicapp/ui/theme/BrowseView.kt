package com.garv.musicapp.ui.theme

import com.garv.musicapp.R
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable

@Composable
fun BrowseView() {

    val categories = listOf("Hits", "Happy", "Workout", "Running", "TGIF", "Yoga")
    LazyVerticalGrid(GridCells.Fixed(2)) {
        items(categories) {
            cat ->
            BrowserItem(cat, drawable = R.drawable.baseline_apps_24)
        }
    }
}