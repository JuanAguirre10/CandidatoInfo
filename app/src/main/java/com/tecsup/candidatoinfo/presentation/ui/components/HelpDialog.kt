package com.tecsup.candidatoinfo.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.tecsup.candidatoinfo.presentation.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpDialog(
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.85f),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                TopAppBar(
                    title = {
                        Text(
                            "Cómo usar la app",
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onDismiss) {
                            Icon(Icons.Default.Close, "Cerrar")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Blue600,
                        titleContentColor = White,
                        navigationIconContentColor = White
                    )
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Gray50)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        HelpSection(
                            icon = "🔍",
                            title = "Buscar Candidatos",
                            description = "Usa la barra de búsqueda para encontrar candidatos por nombre o partido político."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "🏛️",
                            title = "Filtrar por Cargo",
                            description = "Toca los botones 'Congreso' o 'Presidencia' para filtrar candidatos según el cargo al que postulan."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "📍",
                            title = "Filtrar por Región",
                            description = "Desliza horizontalmente para ver filtros de región: Lima, Cusco, Arequipa, etc."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "👤",
                            title = "Ver Perfil del Candidato",
                            description = "Toca UNA VEZ sobre cualquier candidato para ver su perfil completo con denuncias y proyectos."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "✅",
                            title = "Seleccionar para Comparar",
                            description = "Toca DOS VECES RÁPIDO (doble toque) sobre un candidato para seleccionarlo. La tarjeta se pondrá VERDE."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "⚖️",
                            title = "Modo Comparación",
                            description = "Cuando selecciones un candidato, entras en 'Modo Comparación'. Ahora con UN SOLO TOQUE puedes seleccionar más candidatos."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "📊",
                            title = "Comparar Candidatos",
                            description = "Selecciona de 2 a 3 candidatos. Aparecerá un botón azul 'Comparar' abajo. Tócalo para ver la comparación con gráficos."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "📝",
                            title = "Proyectos",
                            description = "El badge verde con 📝 muestra cuántos proyectos de ley ha presentado el candidato."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "⚖️",
                            title = "Denuncias",
                            description = "El badge rojo con ⚖️ muestra cuántas denuncias tiene el candidato. Sin badge = sin denuncias."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "🔄",
                            title = "Actualizar Lista",
                            description = "Desliza hacia ABAJO en la lista de candidatos para actualizar la información."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "🔗",
                            title = "Fuentes Oficiales",
                            description = "En el perfil de cada candidato, puedes tocar 'ver en fuente oficial' para verificar la información en sitios del gobierno."
                        )
                    }

                    item {
                        HelpSection(
                            icon = "💡",
                            title = "Consejo",
                            description = "Compara candidatos antes de decidir tu voto. Revisa sus propuestas, proyectos presentados y si tienen denuncias.",
                            backgroundColor = Yellow50,
                            textColor = Gray900
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HelpSection(
    icon: String,
    title: String,
    description: String,
    backgroundColor: androidx.compose.ui.graphics.Color = White,
    textColor: androidx.compose.ui.graphics.Color = TextPrimary
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Surface(
                shape = CircleShape,
                color = Blue50,
                modifier = Modifier.size(48.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = icon,
                        fontSize = 24.sp
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary
                )
            }
        }
    }
}