package com.tecsup.candidatoinfo.presentation.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.tecsup.candidatoinfo.core.util.IntentHelper
import com.tecsup.candidatoinfo.core.util.UiState
import com.tecsup.candidatoinfo.data.model.Denuncia
import com.tecsup.candidatoinfo.data.model.Propuesta
import com.tecsup.candidatoinfo.presentation.ui.components.*
import com.tecsup.candidatoinfo.presentation.ui.theme.*
import com.tecsup.candidatoinfo.presentation.viewmodel.DetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    candidatoId: String,
    navController: NavController,
    viewModel: DetailViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val candidatoState by viewModel.candidatoState.collectAsState()
    val denunciasState by viewModel.denunciasState.collectAsState()
    val propuestasState by viewModel.propuestasState.collectAsState()
    val selectedTab by viewModel.selectedTab.collectAsState()

    val tabs = listOf("proyectos", "Denuncias")

    LaunchedEffect(candidatoId) {
        viewModel.loadCandidatoData(candidatoId)
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
        when (candidatoState) {
            is UiState.Loading -> {
                LoadingIndicator(message = "Cargando información del candidato...")
            }

            is UiState.Error -> {
                val errorMessage = (candidatoState as UiState.Error).message
                ErrorState(
                    message = errorMessage,
                    onRetry = { viewModel.loadCandidatoData(candidatoId) }
                )
            }

            is UiState.Success -> {
                val candidato = (candidatoState as UiState.Success).data

                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .background(Gray50)
                        .padding(paddingValues),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
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

                    item {
                        InfoCard(title = "Datos Personales") {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                InfoRow("edad", "${candidato.edad} años")
                                InfoRow("formación", "${candidato.profesion}")
                                InfoRow("lugar de nacimiento", candidato.lugarNacimiento)
                                InfoRow("ocupación", "candidato a ${candidato.cargo}")
                            }
                        }
                    }

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
                                        count = candidato.numeroProyectos,
                                        backgroundColor = Blue600,
                                        onClick = { viewModel.updateSelectedTab(0) }
                                    )

                                    IndicadorButton(
                                        icon = "⚖️",
                                        label = "Denuncias\nRegistradas",
                                        count = candidato.numeroDenuncias,
                                        backgroundColor = Red600,
                                        onClick = { viewModel.updateSelectedTab(1) }
                                    )
                                }
                            }
                        }
                    }

                    item {
                        TabRow(
                            selectedTabIndex = selectedTab,
                            containerColor = White,
                            contentColor = Blue600
                        ) {
                            tabs.forEachIndexed { index, title ->
                                Tab(
                                    selected = selectedTab == index,
                                    onClick = { viewModel.updateSelectedTab(index) },
                                    text = { Text(title) }
                                )
                            }
                        }
                    }

                    when (selectedTab) {
                        0 -> {
                            when (propuestasState) {
                                is UiState.Loading -> {
                                    item {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(200.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            CircularProgressIndicator(color = Blue600)
                                        }
                                    }
                                }

                                is UiState.Success -> {
                                    val propuestas = (propuestasState as UiState.Success).data
                                    items(propuestas) { propuesta ->
                                        ProyectoItem(
                                            propuesta = propuesta,
                                            onClickLink = {
                                                IntentHelper.openExternalLink(
                                                    context,
                                                    propuesta.linkFuenteOficial
                                                )
                                            }
                                        )
                                    }
                                }

                                is UiState.Empty -> {
                                    item {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(200.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Este candidato no tiene proyectos registrados",
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = TextSecondary
                                            )
                                        }
                                    }
                                }

                                is UiState.Error -> {
                                    item {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(200.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Error al cargar proyectos",
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = Red600
                                            )
                                        }
                                    }
                                }

                                else -> {}
                            }
                        }

                        1 -> {
                            when (denunciasState) {
                                is UiState.Loading -> {
                                    item {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(200.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            CircularProgressIndicator(color = Red600)
                                        }
                                    }
                                }

                                is UiState.Success -> {
                                    val denuncias = (denunciasState as UiState.Success).data
                                    items(denuncias) { denuncia ->
                                        DenunciaItem(
                                            denuncia = denuncia,
                                            onClick = {
                                                navController.navigate("denuncia/${candidato.id}/${denuncia.id}")
                                            }
                                        )
                                    }
                                }

                                is UiState.Empty -> {
                                    item {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(200.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Column(
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.spacedBy(8.dp)
                                            ) {
                                                Text(text = "✅", fontSize = 48.sp)
                                                Text(
                                                    text = "Sin denuncias registradas",
                                                    style = MaterialTheme.typography.bodyLarge,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = Green600
                                                )
                                                Text(
                                                    text = "Este candidato no tiene denuncias en su historial",
                                                    style = MaterialTheme.typography.bodyMedium,
                                                    color = TextSecondary
                                                )
                                            }
                                        }
                                    }
                                }

                                is UiState.Error -> {
                                    item {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(200.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Error al cargar denuncias",
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = Red600
                                            )
                                        }
                                    }
                                }

                                else -> {}
                            }
                        }
                    }
                }
            }

            else -> {}
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
    count: Int,
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
            .height(90.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = icon, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "$count", fontSize = 20.sp, fontWeight = FontWeight.Bold)
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
    propuesta: Propuesta,
    onClickLink: () -> Unit
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
                text = "📝 ${propuesta.titulo}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = propuesta.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Categoría: ${propuesta.categoria}",
                style = MaterialTheme.typography.bodySmall,
                color = Blue600,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    val estadoColor = when (propuesta.estado) {
                        "Aprobado" -> Green600
                        "En Debate" -> Yellow600
                        "Rechazado" -> Red600
                        else -> Blue600
                    }

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = estadoColor
                        ),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(propuesta.estado, fontSize = 12.sp)
                    }

                    Text(
                        text = propuesta.fechaPresentacion,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = TextSecondary,
                        fontSize = 12.sp
                    )
                }

                TextButton(onClick = onClickLink) {
                    Text("Ver fuente →")
                }
            }
        }
    }
}

@Composable
fun DenunciaItem(
    denuncia: Denuncia,
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "⚖️ ${denuncia.titulo}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                // Badge de gravedad
                val gravedadColor = when (denuncia.gravedad.name) {
                    "ALTA" -> Red600
                    "MEDIA" -> Yellow600
                    else -> Gray500
                }

                Surface(
                    color = gravedadColor.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = denuncia.gravedad.name,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        color = gravedadColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = denuncia.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Tipo: ${denuncia.tipo}",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
                Text(text = "•", color = TextSecondary)
                Text(
                    text = denuncia.entidadInvestigadora,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
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
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(denuncia.estado, fontSize = 12.sp)
                }

                Text(
                    text = denuncia.fechaDenuncia,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    color = TextSecondary,
                    fontSize = 12.sp
                )
            }
        }
    }
}