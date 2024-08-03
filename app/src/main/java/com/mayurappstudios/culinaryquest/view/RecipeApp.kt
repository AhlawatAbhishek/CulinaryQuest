package com.mayurappstudios.culinaryquest.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mayurappstudios.culinaryquest.model.Category
import com.mayurappstudios.culinaryquest.viewmodel.MainViewModel

@Composable
fun RecipeApp(modifier: Modifier = Modifier, navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState = recipeViewModel.categoryState
    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(Screen.RecipeScreen.route) {
            RecipeScreen(viewState = viewState.value, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("categoryObj", it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(Screen.DetailScreen.route) {
            val categoryObj =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("categoryObj")
                    ?: Category("", "", "")
            CategoryDetailScreen(category = categoryObj)
        }
    }
}