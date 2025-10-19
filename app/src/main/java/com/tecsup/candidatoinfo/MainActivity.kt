package com.tecsup.candidatoinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tecsup.candidatoinfo.core.navigation.NavigationHost
import com.tecsup.candidatoinfo.presentation.ui.theme.CandidatoInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CandidatoInfoTheme {
                NavigationHost()
            }
        }
    }
}