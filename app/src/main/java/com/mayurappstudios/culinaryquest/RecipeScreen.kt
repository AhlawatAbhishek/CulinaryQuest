package com.mayurappstudios.culinaryquest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RecipeScreen(modifier: Modifier = Modifier, viewState : MainViewModel.RecipeState, navigateToDetail : (Category) -> Unit) {
     val recipeViewModel: MainViewModel = viewModel()

    Box(modifier = modifier.fillMaxSize()){
            when{
                viewState.loading -> {
                        CircularProgressIndicator(modifier.align(Alignment.Center))
                }
                viewState.error != null -> {
                        Text("ERROR: ${viewState.error}", modifier.align(Alignment.Center))
                }
                else -> {
                        //Display the list of categories
                        CategoryScreen(categories = viewState.categories, navigateToDetail)
                }
            }
    }
}
