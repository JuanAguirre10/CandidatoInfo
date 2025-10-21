package com.tecsup.candidatoinfo.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tecsup.candidatoinfo.presentation.ui.screens.home.HomeScreen
import com.tecsup.candidatoinfo.presentation.ui.screens.detail.DetailScreen
import com.tecsup.candidatoinfo.presentation.ui.screens.detail.DenunciaDetailScreen
import com.tecsup.candidatoinfo.presentation.ui.screens.compare.CompareScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController = navController)
        }

        composable("detail/{candidatoId}") { backStackEntry ->
            val candidatoId = backStackEntry.arguments?.getString("candidatoId") ?: ""
            DetailScreen(
                candidatoId = candidatoId,
                navController = navController
            )
        }

        composable("denuncia/{candidatoId}/{denunciaId}") { backStackEntry ->
            val candidatoId = backStackEntry.arguments?.getString("candidatoId") ?: ""
            val denunciaId = backStackEntry.arguments?.getString("denunciaId") ?: ""
            DenunciaDetailScreen(
                candidatoId = candidatoId,
                denunciaId = denunciaId,
                navController = navController
            )
        }

        composable("compare") {
            CompareScreen(navController = navController)
        }
    }
}