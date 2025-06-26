package com.garv.recipeapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController : NavHostController, paddingValues: PaddingValues) {
    val recipeViewModel : MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(
                viewState = viewState,
                navigateToDetail = { category ->
                    // Pass the category ID as a route parameter
                    navController.navigate("${Screen.DetailedScreen.route}/${category.idCategory}")
                },
                modifier = Modifier,
                paddingValues = paddingValues
            )
        }
        composable(route = "${Screen.DetailedScreen.route}/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId") ?: ""
            // Find the category from the viewModel
            val category = viewState.list.find { it.idCategory == categoryId }
                ?: Category("", "Not Found", "", "Category not found")
            CategoryDetailScreen(category = category, paddingValues = paddingValues)
        }
    }
}