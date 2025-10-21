package com.tecsup.candidatoinfo.presentation.ui.screens.home

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tecsup.candidatoinfo.core.util.UiState
import com.tecsup.candidatoinfo.presentation.ui.components.*
import com.tecsup.candidatoinfo.presentation.ui.theme.*
import com.tecsup.candidatoinfo.presentation.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedFilter by viewModel.selectedFilter.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "CandidatoInfo",
                            fontWeight = FontWeight.Bold,
                            color = Blue600
                        )
                        Text(
                            text = " ⚖️",
                            fontSize = 24.sp
                        )
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
        ) {
            SearchBarComponent(
                query = searchQuery,
                onQueryChange = { viewModel.updateSearchQuery(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

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
                        viewModel.updateFilter(
                            if (selectedFilter == "Congreso") "Todos" else "Congreso"
                        )
                    }
                )
                FilterChipCustom(
                    label = "Presidencia",
                    selected = selectedFilter == "Presidencia",
                    onClick = {
                        viewModel.updateFilter(
                            if (selectedFilter == "Presidencia") "Todos" else "Presidencia"
                        )
                    }
                )
                FilterChipCustom(
                    label = "Lima",
                    selected = false,
                    onClick = { /* Implementar filtro por región */ }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            when (uiState) {
                is UiState.Idle -> {
                }

                is UiState.Loading -> {
                    LoadingIndicator(message = "Cargando candidatos...")
                }

                is UiState.Success -> {
                    val candidatos = (uiState as UiState.Success).data

                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(candidatos) { candidato ->
                            CandidatoCard(
                                candidato = candidato,
                                onClick = {
                                    navController.navigate("detail/${candidato.id}")
                                }
                            )
                        }
                    }
                }

                is UiState.Empty -> {
                    EmptyState(
                        icon = "🔍",
                        title = "No hay resultados",
                        message = "No se encontraron candidatos con los filtros aplicados",
                        actionLabel = "Limpiar filtros",
                        onAction = { viewModel.resetFilters() }
                    )
                }

                is UiState.Error -> {
                    val errorMessage = (uiState as UiState.Error).message
                    ErrorState(
                        message = errorMessage,
                        onRetry = { viewModel.loadCandidatos() }
                    )
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