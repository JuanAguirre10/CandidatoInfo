package com.tecsup.candidatoinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tecsup.candidatoinfo.core.navigation.NavigationHost
import com.tecsup.candidatoinfo.ui.theme.CandidatoInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CandidatoInfoAppUI()
        }
    }
}

@Composable
fun CandidatoInfoAppUI() {
    CandidatoInfoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavigationHost()
        }
    }
}
