package com.garv.recipeapp

sealed class Screen(val route: String) {
    object RecipeScreen: Screen("recipescreen")
    object DetailedScreen: Screen("detailscreen")
}