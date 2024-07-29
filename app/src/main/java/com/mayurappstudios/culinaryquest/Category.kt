package com.mayurappstudios.culinaryquest

//Category data class for data fetching from themealdb.com API
//Pay attention to the variable in the parameter of the data class they need to be
//exactly the same as the JSON response from the API
//The api Url is https://www.themealdb.com/api/json/v1/1/categories.php
data class Category(val idCategory: String,
                    val strCategory: String,
                    val strCategoryThumb: String,
    val strCategoryDescription: String = "")

data class CategoriesResponse(val categories: List<Category>)