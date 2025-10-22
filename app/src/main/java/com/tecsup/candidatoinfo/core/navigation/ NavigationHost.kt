package com.tecsup.candidatoinfo.core.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tecsup.candidatoinfo.presentation.ui.screens.home.HomeScreen
import com.tecsup.candidatoinfo.presentation.ui.screens.detail.DetailScreen
import com.tecsup.candidatoinfo.presentation.ui.screens.detail.DenunciaDetailScreen
import com.tecsup.candidatoinfo.presentation.ui.screens.compare.CompareScreen
import com.tecsup.candidatoinfo.presentation.viewmodel.CompareViewModel
import com.tecsup.candidatoinfo.presentation.splash.SplashScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    val compareViewModel: CompareViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "splash"
    )  {
        composable("splash") { SplashScreen(navController) }
        composable("home") {
            HomeScreen(
                navController = navController,
                compareViewModel = compareViewModel
            )
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
            CompareScreen(
                navController = navController,
                compareViewModel = compareViewModel
            )
        }
    }
}