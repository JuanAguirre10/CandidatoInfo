package com.tecsup.candidatoinfo.presentation.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.tecsup.candidatoinfo.data.datasource.MockDataSource
import com.tecsup.candidatoinfo.presentation.ui.components.InfoCard
import com.tecsup.candidatoinfo.presentation.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    candidatoId: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val candidato = MockDataSource.candidatos.find { it.id == candidatoId }
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("proyectos", "Denuncias")

    if (candidato == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Candidato no encontrado")
        }
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("volver") },
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
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(Gray50)
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header con foto y datos básicos
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = White),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = candidato.fotoUrl,
                            contentDescription = "Foto de ${candidato.nombreCompleto}",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = candidato.nombreCompleto,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )

                        Text(
                            text = candidato.partidoPolitico,
                            style = MaterialTheme.typography.bodyLarge,
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                            color = TextSecondary
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = candidato.cargo,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Blue600
                        )
                    }
                }
            }

            // Datos personales
            item {
                InfoCard(title = "Datos Personales") {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        InfoRow("edad", "${candidato.edad} años")
                        InfoRow("formación", "${candidato.profesion} - universidad ${candidato.lugarNacimiento}")
                        InfoRow("ocupación", "candidato a ${candidato.cargo}")
                    }
                }
            }

            // Indicadores rápidos
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = White),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "indicadores rápidos",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            IndicadorButton(
                                icon = "📝",
                                label = "proyectos\npresentados",
                                backgroundColor = Blue600,
                                onClick = { selectedTab = 0 }
                            )

                            IndicadorButton(
                                icon = "⚖️",
                                label = "Denuncias\nRegistradas",
                                backgroundColor = Red600,
                                onClick = { selectedTab = 1 }
                            )
                        }
                    }
                }
            }

            // Tabs
            item {
                TabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = White,
                    contentColor = Blue600
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = { Text(title) }
                        )
                    }
                }
            }

            // Contenido de tabs
            when (selectedTab) {
                0 -> {
                    item {
                        ProyectoItem(
                            titulo = "📝 reforma del sistema tributario",
                            descripcion = "propuesta para simplificar el sistema monetario y reducir la evasión fiscal.",
                            estado = "presentado",
                            fecha = "14-02-2014",
                            estadoColor = Blue600
                        )
                    }
                }
                1 -> {
                    item {
                        DenunciaItem(
                            titulo = "⚖️ investigación por presuntos intereses",
                            descripcion = "denuncia archivada por falta de meritos tras la investigacion de la comisión.",
                            estado = "archivado",
                            fecha = "06-10-2015",
                            onClick = {
                                navController.navigate("denuncia/${candidato.id}")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row {
        Text(
            text = "$label : ",
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        Text(
            text = value,
            color = TextSecondary
        )
    }
}

@Composable
fun IndicadorButton(
    icon: String,
    label: String,
    backgroundColor: androidx.compose.ui.graphics.Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(140.dp)
            .height(80.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = icon, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                fontSize = 10.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
fun ProyectoItem(
    titulo: String,
    descripcion: String,
    estado: String,
    fecha: String,
    estadoColor: androidx.compose.ui.graphics.Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = titulo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = estadoColor
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(estado)
                }

                Text(
                    text = fecha,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    color = TextSecondary
                )
            }
        }
    }
}

@Composable
fun DenunciaItem(
    titulo: String,
    descripcion: String,
    estado: String,
    fecha: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = titulo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Gray500
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(estado)
                }

                Text(
                    text = fecha,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    color = TextSecondary
                )
            }
        }
    }
}