package com.rachmadhani.lafyuu_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rachmadhani.lafyuu_ui.theme.LafyuuUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LafyuuUITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    AppTugasUI()
                }
            }
        }
    }
}

@Composable
fun AppTugasUI() {
    val navController :NavHostController = rememberNavController()
    var startDestination = "login"

    NavHost(navController = navController, startDestination = startDestination) {
        composable("login") { Login(navController) }
        composable("register") { Register(navController) }
        composable("home") { Home(navController)}
        composable("superFlashSale") { SuperFlashSaleScreen(navController) }
        composable("favorite") { FavoriteProductScreen(navController) }
    }
}