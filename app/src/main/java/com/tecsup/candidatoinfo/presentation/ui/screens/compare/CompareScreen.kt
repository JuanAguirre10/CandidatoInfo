package com.tecsup.candidatoinfo.presentation.ui.screens.compare

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tecsup.candidatoinfo.data.model.Candidato
import com.tecsup.candidatoinfo.presentation.ui.theme.*
import com.tecsup.candidatoinfo.presentation.viewmodel.CompareViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompareScreen(
    navController: NavController,
    compareViewModel: CompareViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val selectedCandidatos by remember { compareViewModel.selectedCandidatos }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Comparar Candidatos") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Volver")
                    }
                },
                actions = {
                    if (selectedCandidatos.isNotEmpty()) {
                        IconButton(onClick = {
                            val shareText = buildShareText(selectedCandidatos)
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, shareText)
                            }
                            context.startActivity(Intent.createChooser(intent, "Compartir comparación"))
                        }) {
                            Icon(Icons.Default.Share, "Compartir")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = White
                )
            )
        }
    ) { paddingValues ->
        if (selectedCandidatos.size < 2) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Selecciona al menos 2 candidatos para comparar",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextSecondary
                )
            }
        } else {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .background(Gray50)
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    ComparisonTable(candidatos = selectedCandidatos)
                }

                item {
                    StatisticsComparison(candidatos = selectedCandidatos)
                }

                item {
                    DenunciasComparison(candidatos = selectedCandidatos)
                }
            }
        }
    }
}

@Composable
fun ComparisonTable(candidatos: List<Candidato>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Comparación General",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    ComparisonRow("Campo", "", isHeader = true)
                    ComparisonRow("Nombre", "")
                    ComparisonRow("Partido", "")
                    ComparisonRow("Edad", "")
                    ComparisonRow("Profesión", "")
                    ComparisonRow("Proyectos", "")
                    ComparisonRow("Denuncias", "")
                }

                candidatos.forEach { candidato ->
                    Column(modifier = Modifier.weight(1f)) {
                        ComparisonRow("", "", isHeader = true)
                        ComparisonRow("", candidato.nombreCompleto.split(" ").take(2).joinToString(" "))
                        ComparisonRow("", candidato.partidoPolitico.take(20))
                        ComparisonRow("", "${candidato.edad} años")
                        ComparisonRow("", candidato.profesion.split("-").first().trim())
                        ComparisonRow("", "${candidato.numeroProyectos}", highlight = candidato.numeroProyectos == candidatos.maxOf { it.numeroProyectos })
                        ComparisonRow("", "${candidato.numeroDenuncias}", highlight = candidato.numeroDenuncias == candidatos.minOf { it.numeroDenuncias })
                    }
                }
            }
        }
    }
}

@Composable
fun ComparisonRow(
    label: String,
    value: String,
    isHeader: Boolean = false,
    highlight: Boolean = false
) {
    val bgColor = when {
        isHeader -> Blue600
        highlight -> Green50
        else -> White
    }

    val textColor = if (isHeader) White else TextPrimary

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        color = bgColor,
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            text = if (label.isNotEmpty()) label else value,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodySmall,
            fontWeight = if (isHeader || highlight) FontWeight.Bold else FontWeight.Normal,
            color = textColor,
            maxLines = 2
        )
    }
}

@Composable
fun StatisticsComparison(candidatos: List<Candidato>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Gráfico Comparativo",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            candidatos.forEach { candidato ->
                CandidateBar(
                    nombre = candidato.nombreCompleto.split(" ").take(2).joinToString(" "),
                    proyectos = candidato.numeroProyectos,
                    maxProyectos = candidatos.maxOf { it.numeroProyectos }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Denuncias",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            candidatos.forEach { candidato ->
                DenunciaBar(
                    nombre = candidato.nombreCompleto.split(" ").take(2).joinToString(" "),
                    denuncias = candidato.numeroDenuncias,
                    maxDenuncias = candidatos.maxOf { it.numeroDenuncias }.coerceAtLeast(1)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun CandidateBar(
    nombre: String,
    proyectos: Int,
    maxProyectos: Int
) {
    Column {
        Text(
            text = nombre,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LinearProgressIndicator(
                progress = if (maxProyectos > 0) proyectos.toFloat() / maxProyectos else 0f,
                modifier = Modifier
                    .weight(1f)
                    .height(24.dp),
                color = Green600,
                trackColor = Green50
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "$proyectos",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Green600
            )
        }
    }
}

@Composable
fun DenunciaBar(
    nombre: String,
    denuncias: Int,
    maxDenuncias: Int
) {
    Column {
        Text(
            text = nombre,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LinearProgressIndicator(
                progress = if (maxDenuncias > 0) denuncias.toFloat() / maxDenuncias else 0f,
                modifier = Modifier
                    .weight(1f)
                    .height(24.dp),
                color = if (denuncias == 0) Green600 else Red600,
                trackColor = if (denuncias == 0) Green50 else Red50
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "$denuncias",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = if (denuncias == 0) Green600 else Red600
            )
        }
    }
}

@Composable
fun DenunciasComparison(candidatos: List<Candidato>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Resumen de Denuncias",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            candidatos.forEach { candidato ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = candidato.nombreCompleto.split(" ").take(2).joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f)
                    )

                    Surface(
                        color = if (candidato.numeroDenuncias == 0) Green50 else Red50,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = if (candidato.numeroDenuncias == 0) "Sin denuncias ✓" else "${candidato.numeroDenuncias} denuncias",
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            color = if (candidato.numeroDenuncias == 0) Green600 else Red600,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                if (candidato != candidatos.last()) {
                    Divider(modifier = Modifier.padding(vertical = 4.dp))
                }
            }
        }
    }
}

fun buildShareText(candidatos: List<Candidato>): String {
    val sb = StringBuilder()
    sb.append("📊 Comparación de Candidatos - CandidatoInfo\n\n")

    candidatos.forEach { candidato ->
        sb.append("👤 ${candidato.nombreCompleto}\n")
        sb.append("   ${candidato.partidoPolitico}\n")
        sb.append("   📝 ${candidato.numeroProyectos} proyectos\n")
        sb.append("   ⚖️ ${candidato.numeroDenuncias} denuncias\n\n")
    }

    sb.append("🗳️ Elecciones 2026 - Vota informado")
    return sb.toString()
}