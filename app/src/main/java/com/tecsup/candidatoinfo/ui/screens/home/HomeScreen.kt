package com.tecsup.candidatoinfo.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tecsup.candidatoinfo.data.datasource.MockDataSource
import com.tecsup.candidatoinfo.ui.components.CandidatoCard
import com.tecsup.candidatoinfo.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("Todos") }

    val candidatos = MockDataSource.candidatos

    // 🔍 Filtrado dinámico
    val candidatosFiltrados = remember(selectedFilter, searchQuery) {
        var filtered = when (selectedFilter) {
            "Congreso" -> candidatos.filter { it.cargo.contains("Congres", ignoreCase = true) }
            "Presidencia" -> candidatos.filter { it.cargo.contains("President", ignoreCase = true) }
            else -> candidatos
        }

        if (searchQuery.isNotBlank()) {
            filtered = filtered.filter {
                it.nombreCompleto.contains(searchQuery, ignoreCase = true) ||
                        it.partidoPolitico.contains(searchQuery, ignoreCase = true)
            }
        }

        filtered
    }

    // 🧱 Estructura general
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "CandidatoInfo",
                            color = Blue600,
                            fontSize = 20.sp
                        )
                        Text(
                            text = " ⚖️",
                            fontSize = 24.sp
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = White)
            )
        }
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Gray50)
                .padding(padding)
        ) {
            // 🔍 Barra de búsqueda
            SearchBarComponent(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // 🔘 Chips de filtro
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChipCustom(
                    label = "Congreso",
                    selected = selectedFilter == "Congreso",
                    onClick = {
                        selectedFilter = if (selectedFilter == "Congreso") "Todos" else "Congreso"
                    }
                )
                FilterChipCustom(
                    label = "Presidencia",
                    selected = selectedFilter == "Presidencia",
                    onClick = {
                        selectedFilter = if (selectedFilter == "Presidencia") "Todos" else "Presidencia"
                    }
                )
            }

            Spacer(Modifier.height(16.dp))

            // 🧾 Lista de candidatos
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(candidatosFiltrados) { candidato ->
                    CandidatoCard(
                        candidato = candidato,
                        onClick = {
                            navController.navigate("detail/${candidato.id}")
                        }
                    )
                }

                // 🧩 Mensaje si no hay resultados
                if (candidatosFiltrados.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No se encontraron candidatos",
                                style = MaterialTheme.typography.bodyLarge,
                                color = TextSecondary
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarComponent(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier,
        placeholder = {
            Text("buscar candidato, partido o región")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Buscar"
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = White,
            unfocusedContainerColor = White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Blue600
        ),
        singleLine = true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipCustom(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(label) },
        modifier = modifier,
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Blue600,
            selectedLabelColor = White,
            containerColor = White,
            labelColor = Gray700
        )
    )
}
