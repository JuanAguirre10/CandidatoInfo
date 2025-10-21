package com.tecsup.candidatoinfo.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tecsup.candidatoinfo.data.model.Candidato
import com.tecsup.candidatoinfo.presentation.ui.theme.*

@Composable
fun CandidatoCard(
    candidato: Candidato,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            AsyncImage(
                model = candidato.fotoUrl,
                contentDescription = "Foto de ${candidato.nombreCompleto}",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )


            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Text(
                    text = candidato.nombreCompleto,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )


                Text(
                    text = candidato.partidoPolitico,
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    color = TextSecondary
                )


                Text(
                    text = candidato.cargo,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Blue600
                )

                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    IndicadorBadge(
                        icon = "📝",
                        count = candidato.numeroProyectos,
                        label = "proyectos",
                        backgroundColor = Green50,
                        textColor = Green600
                    )


                    if (candidato.numeroDenuncias > 0) {
                        IndicadorBadge(
                            icon = "⚖️",
                            count = candidato.numeroDenuncias,
                            label = "denuncias",
                            backgroundColor = Red50,
                            textColor = Red600
                        )
                    }
                }
            }
        }
    }
}