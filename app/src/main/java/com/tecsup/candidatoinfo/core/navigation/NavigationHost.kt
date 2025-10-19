package com.tecsup.candidatoinfo.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import com.tecsup.candidatoinfo.ui.screens.home.HomeScreen
import com.tecsup.candidatoinfo.ui.screens.detail.DetailScreen
import com.tecsup.candidatoinfo.ui.screens.compare.CompareScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // 🏠 Pantalla de inicio
        composable("home") {
            HomeScreen(navController = navController)
        }

        // 👤 Pantalla de detalle de candidato
        composable("detail/{candidatoId}") { backStackEntry ->
            val candidatoId = backStackEntry.arguments?.getString("candidatoId") ?: ""
            DetailScreen(
                candidatoId = candidatoId,
                navController = navController
            )
        }

        // ⚖️ Pantalla de comparación de candidatos
        composable("compare") {
            CompareScreen(navController = navController)
        }
    }
}
