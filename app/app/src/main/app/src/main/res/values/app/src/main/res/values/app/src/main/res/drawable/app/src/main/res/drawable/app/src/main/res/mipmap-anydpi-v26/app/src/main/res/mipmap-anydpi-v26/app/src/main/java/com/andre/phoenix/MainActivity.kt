package com.andre.phoenix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andre.phoenix.ui.DashboardScreen
import com.andre.phoenix.ui.LoginScreen
import com.andre.phoenix.ui.OsListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface { AppNav() }
            }
        }
    }
}

@Composable
fun AppNav() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "login") {
        composable("login") { LoginScreen(onLogin = { nav.navigate("dashboard") }) }
        composable("dashboard") { DashboardScreen(onOpenOs = { nav.navigate("os") }) }
        composable("os") { OsListScreen(onBack = { nav.popBackStack() }) }
    }
}
