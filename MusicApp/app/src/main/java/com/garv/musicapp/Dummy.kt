package com.garv.musicapp

import androidx.annotation.DrawableRes

data class Lib(@DrawableRes val icon: Int, val name: String)

val libraries = listOf<Lib>(
    Lib(R.drawable.playlist, "PlayList"),
    Lib(R.drawable.artist, "Artist"),
    Lib(R.drawable.album, "Album"),
    Lib(R.drawable.music, "Songs"),
    Lib(R.drawable.genre, "Genre"),
)
