package com.example.lvluptemplate.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lvluptemplate.resources.SongEntity

@Composable
fun SongResultRow(
    song: SongEntity,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(12.dp)
    ) {

        Box(modifier = Modifier.size(50.dp))

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(text = song.title, color = MaterialTheme.colorScheme.onBackground)
            Text(text = song.artist, style = MaterialTheme.typography.bodySmall)
        }
    }
}