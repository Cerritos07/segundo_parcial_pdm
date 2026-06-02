package com.example.lvluptemplate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lvluptemplate.resources.SongEntity

@Composable
fun SongCard(
    song: SongEntity,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            // Simulación de imagen presentada
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = song.title,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )

            Text(
                text = song.artist,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.LightGray
            )
        }
    }
}