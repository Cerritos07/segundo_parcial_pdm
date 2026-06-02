package com.example.lvluptemplate.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NavBar(navController: NavController) {

    NavigationBar {

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("main") },
            icon = { Icon(Icons.Default.Home, "Home") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("search") },
            icon = { Icon(Icons.Default.Search, "Search") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("playlistScreen") },
            icon = { Icon(Icons.Default.List, "Playlist") }
        )
    }
}

