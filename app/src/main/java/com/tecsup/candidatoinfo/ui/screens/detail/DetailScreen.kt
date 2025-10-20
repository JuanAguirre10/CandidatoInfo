package com.tecsup.candidatoinfo.ui.screens.detail

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
import com.tecsup.candidatoinfo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    candidatoId: String,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val candidato = remember(candidatoId) {
        MockDataSource.candidatos.find { it.id == candidatoId }
    }

    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Proyectos", "Denuncias")

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
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = White)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(Gray50)
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 🧑 Header con foto y datos
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

                        Spacer(Modifier.height(16.dp))

                        Text(
                            text = candidato.nombreCompleto,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )

                        Text(
                            text = candidato.partidoPolitico,
                            style = MaterialTheme.typography.bodyLarge,
                            color = TextSecondary
                        )

                        Spacer(Modifier.height(4.dp))

                        Text(
                            text = candidato.cargo,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Blue600
                        )
                    }
                }
            }

            // 📄 Datos personales
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = White),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Datos personales",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(12.dp))
                        InfoRow("Edad", "${candidato.edad} años")
                        InfoRow("Formación", "${candidato.profesion}")
                        InfoRow("Región", "${candidato.lugarNacimiento}")
                    }
                }
            }

            // ⚡ Indicadores rápidos
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = White),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Indicadores rápidos",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            IndicadorButton(
                                icon = "📝",
                                label = "Proyectos\npresentados",
                                backgroundColor = Blue600
                            ) { selectedTab = 0 }

                            IndicadorButton(
                                icon = "⚖️",
                                label = "Denuncias\nregistradas",
                                backgroundColor = Red600
                            ) { selectedTab = 1 }
                        }
                    }
                }
            }

            // 🧭 Tabs
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

            // 📑 Contenido dinámico
            when (selectedTab) {
                0 -> {
                    item {
                        ProyectoItem(
                            titulo = "📝 Reforma del sistema tributario",
                            descripcion = "Propuesta para simplificar el sistema y reducir la evasión fiscal.",
                            estado = "presentado",
                            fecha = "14-02-2014",
                            estadoColor = Blue600
                        )
                    }
                }

                1 -> {
                    item {
                        DenunciaItem(
                            titulo = "⚖️ Investigación por intereses",
                            descripcion = "Denuncia archivada por falta de méritos tras investigación.",
                            estado = "archivado",
                            fecha = "06-10-2015",
                            onClick = { navController.navigate("denuncia/${candidato.id}") }
                        )
                    }
                }
            }
        }
    }
}

// 🔹 Info simple en fila
@Composable
fun InfoRow(label: String, value: String) {
    Row {
        Text(text = "$label: ", fontWeight = FontWeight.Bold, color = TextPrimary)
        Text(text = value, color = TextSecondary)
    }
}

// 🔹 Botón de indicadores
@Composable
fun IndicadorButton(
    icon: String,
    label: String,
    backgroundColor: androidx.compose.ui.graphics.Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.width(140.dp).height(80.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = icon, fontSize = 24.sp)
            Spacer(Modifier.height(4.dp))
            Text(text = label, fontSize = 10.sp)
        }
    }
}

// 🔹 Item de proyecto
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
        Column(modifier = Modifier.padding(16.dp)) {
            Text(titulo, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text(descripcion, style = MaterialTheme.typography.bodyMedium, color = TextSecondary)
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = estadoColor),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(estado)
                }
                Text(text = fecha, color = TextSecondary)
            }
        }
    }
}

// 🔹 Item de denuncia
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
        Column(modifier = Modifier.padding(16.dp)) {
            Text(titulo, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text(descripcion, style = MaterialTheme.typography.bodyMedium, color = TextSecondary)
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Gray500),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(estado)
                }
                Text(text = fecha, color = TextSecondary)
            }
        }
    }
}
