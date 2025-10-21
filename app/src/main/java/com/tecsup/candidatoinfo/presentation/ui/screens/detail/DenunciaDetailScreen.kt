package com.tecsup.candidatoinfo.presentation.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tecsup.candidatoinfo.core.util.IntentHelper
import com.tecsup.candidatoinfo.data.datasource.MockDataSource
import com.tecsup.candidatoinfo.presentation.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DenunciaDetailScreen(
    candidatoId: String,
    denunciaId: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val denuncia = MockDataSource.getDenunciaById(denunciaId)

    if (denuncia == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Denuncia no encontrada")
        }
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("volver perfil") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Gray50)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val gravedadColor = when (denuncia.gravedad.name) {
                        "ALTA" -> Red600
                        "MEDIA" -> Yellow600
                        else -> Gray500
                    }

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(gravedadColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "⚖️", fontSize = 28.sp)
                    }

                    Column {
                        Text(
                            text = "Denuncias",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Surface(
                            color = gravedadColor.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = "Gravedad: ${denuncia.gravedad.name}",
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                color = gravedadColor,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = denuncia.titulo,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Divider()

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "estado:",
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextSecondary
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            val estadoColor = when (denuncia.estado) {
                                "Archivada", "Desestimada" -> Gray500
                                "Sentenciada" -> Red600
                                else -> Yellow600
                            }

                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = estadoColor
                                ),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(denuncia.estado)
                            }
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "fecha:",
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextSecondary
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = denuncia.fechaDenuncia,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        InfoRowDetail("Tipo:", denuncia.tipo)
                        InfoRowDetail("Entidad:", denuncia.entidadInvestigadora)
                        if (denuncia.fechaResolucion != null) {
                            InfoRowDetail("Fecha resolución:", denuncia.fechaResolucion)
                        }
                    }

                    Divider()

                    Text(
                        text = "DESCRIPCIÓN:",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = denuncia.descripcion,
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextSecondary,
                        lineHeight = 24.sp
                    )

                    Divider()

                    Button(
                        onClick = {
                            IntentHelper.openExternalLink(
                                context,
                                denuncia.linkFuenteOficial
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Black
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("📧 ver en fuente oficial")
                    }
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Yellow50),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(text = "⚠️", fontSize = 24.sp)
                    Text(
                        text = "esta información es de caracter publico y ha sido recopilado por fuentes oficiales.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Gray900
                    )
                }
            }
        }
    }
}

@Composable
fun InfoRowDetail(label: String, value: String) {
    Row {
        Text(
            text = label,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary,
            modifier = Modifier.width(120.dp)
        )
        Text(
            text = value,
            color = TextSecondary
        )
    }
}