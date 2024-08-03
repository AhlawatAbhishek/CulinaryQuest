package com.mayurappstudios.culinaryquest.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayurappstudios.culinaryquest.model.Category
import com.mayurappstudios.culinaryquest.model.apiService
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {
   init {
        fetchCategories()
   }
    private val _categoryState = mutableStateOf(RecipeState())
    val categoryState: State<RecipeState> = _categoryState
    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = apiService.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    loading = false, categories = response.categories
                    , error = null
                )
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