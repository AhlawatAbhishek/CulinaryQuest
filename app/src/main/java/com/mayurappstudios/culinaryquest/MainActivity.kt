package com.mayurappstudios.culinaryquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mayurappstudios.culinaryquest.ui.theme.CulinaryQuestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CulinaryQuestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                       RecipeApp(modifier = Modifier.padding(innerPadding) , navController = navController)
                }
            }
        }
    }
}
