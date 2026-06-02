package com.example.lvluptemplate.screen

import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.lvluptemplate.components.CreatePlaylistDialog
import com.example.lvluptemplate.components.PlaylistCardComponent
import com.example.lvluptemplate.components.AddPlaylistCard
import com.example.lvluptemplate.resources.PlaylistEntity

@Composable
fun PlaylistScreen(navController: NavController) {

    var showDialog by remember { mutableStateOf(false) }

    // LISTA DINÁMICA
    val playlists = remember {
        mutableStateListOf(
            PlaylistEntity("p1", "My Favorites", ""),
            PlaylistEntity("p2", "Daily Drive", "")
        )
    }

    LazyColumn {

        //  LISTA DE PLAYLISTS
        items(playlists) { playlist ->

            PlaylistCardComponent(playlist) {
                navController.navigate("playlist/${playlist.name}")
            }
        }

        // BOTÓN CREAR PLAYLIST
        item {
            AddPlaylistCard {
                showDialog = true
            }
        }
    }

    //  DIALOG
    if (showDialog) {
        CreatePlaylistDialog(

            onDismiss = {
                showDialog = false
            },

            onPlaylistCreated = { name ->

                playlists.add(
                    PlaylistEntity(
                        id = "p${playlists.size + 1}",
                        name = name,
                        description = ""
                    )
                )

                showDialog = false
            }
        )
    }
}
