package com.example.lvluptemplate.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lvluptemplate.resources.DummyData
import com.example.lvluptemplate.components.SongResultRow

@Composable
fun MyPlaylistScreen(
    name: String,
    navController: NavController
) {

    val songs = DummyData.allSongs

    Column(modifier = Modifier.padding(16.dp)) {

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("← Volver")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(songs) { song ->

                SongResultRow(song) {
                    navController.navigate("song/${song.title}/${song.artist}")
                }
            }
        }
    }
}
