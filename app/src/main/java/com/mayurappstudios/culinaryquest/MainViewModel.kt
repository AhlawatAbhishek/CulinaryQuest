package com.mayurappstudios.culinaryquest

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {
    private val _categoryState = mutableStateOf(RecipeState())
    val categoryState: State<RecipeState> = _categoryState
    private fun fetchCategories() {
        viewModelScope.launch {
            try {

            } catch (e: Exception) {
                _categoryState.value = _categoryState.value.copy(
                    loading = false, error = "Error fetching recipe ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val categories: List<Category> = emptyList(),
        val error: String? = null
    )
}