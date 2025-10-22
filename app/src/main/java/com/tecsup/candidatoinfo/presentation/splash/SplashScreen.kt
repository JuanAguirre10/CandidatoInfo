package com.tecsup.candidatoinfo.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.tecsup.candidatoinfo.R
import kotlinx.coroutines.delay
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween

@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 2000),
        label = ""
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }

    // Fondo blanco
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

        // Bandera animada (más grande)
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.peru_flag))
        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever
        )

        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier
                .size(650.dp) // <-- aumenta o reduce aquí (ej. 400–450.dp)
                .align(Alignment.Center)
        )

        // Logo centrado dentro de la franja blanca
        Image(
            painter = painterResource(id = R.drawable.candidatoinfosinfodno),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp) // <-- ajusta el tamaño del logo aquí
                .offset(x = (-7).dp, y = 0.dp)
                .alpha(alphaAnim.value)
                .align(Alignment.Center)
        )
    }
}


