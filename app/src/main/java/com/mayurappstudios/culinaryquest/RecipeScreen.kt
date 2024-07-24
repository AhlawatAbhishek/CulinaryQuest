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
fun RecipeScreen(modifier: Modifier = Modifier) {
     val recipeViewModel: MainViewModel = viewModel()
    val viewState = recipeViewModel.categoryState
    Box(modifier = modifier.fillMaxSize()){
            when{
                viewState.value.loading -> {
                        CircularProgressIndicator(modifier.align(Alignment.Center))
                }
                viewState.value.error != null -> {
                        Text("ERROR: ${viewState.value.error}", modifier.align(Alignment.Center))
                }
                else -> {
                        //Display the list of categories
                        CategoryScreen(categories = viewState.value.categories)
                }
            }
    }
}
