package com.tecsup.candidatoinfo.ui.screens.denuncia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tecsup.candidatoinfo.data.datasource.MockDataSource
import com.tecsup.candidatoinfo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DenunciaDetailScreen(
    candidatoId: String,
    navController: NavController
) {
    val candidato = MockDataSource.candidatos.find { it.id == candidatoId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detalle de Denuncia",
                        color = Blue600,
                        fontSize = 18.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = White)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray50)
                .padding(padding)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            if (candidato == null) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "No se encontró información del candidato.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextSecondary
                    )
                }
                return@Column
            }

            // 🧾 Título
            Text(
                text = "⚖️ Investigación en curso",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            // 📋 Descripción principal
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Denuncia contra ${candidato.nombreCompleto}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Blue600
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "La presente denuncia fue registrada en el año 2022 por presuntas irregularidades en su gestión pública. El caso actualmente se encuentra en investigación por el Ministerio Público.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = "Estado: En investigación",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = Red600
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = "Fecha: 15 de septiembre de 2022",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )
                }
            }

            // 🧩 Bloque de documentación
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Documentos asociados",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Spacer(Modifier.height(12.dp))
                    Text("📑 Oficio Nº 124-2022-MP", color = TextSecondary)
                    Text("📑 Resolución Nº 23-2023", color = TextSecondary)
                    Text("📑 Informe de Contraloría", color = TextSecondary)
                }
            }

            // ✅ Botón final
            Button(
                onClick = { navController.navigateUp() },
                colors = ButtonDefaults.buttonColors(containerColor = Blue600),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Volver al perfil", color = White)
            }
        }
    }
}
