package com.mayurappstudios.culinaryquest

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun RecipeApp(navController: NavController) {
    val recipeViewModel : MainViewModel = viewModel()
}