package com.example.lvluptemplate.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lvluptemplate.resources.PlaylistEntity

@Composable
fun PlaylistCardComponent(
    playlist: PlaylistEntity,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(text = playlist.name)

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Playlist",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
