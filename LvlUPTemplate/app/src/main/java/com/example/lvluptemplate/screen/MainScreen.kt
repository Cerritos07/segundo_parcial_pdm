package com.example.lvluptemplate.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.lvluptemplate.components.SongCard
import com.example.lvluptemplate.components.NavBar
import com.example.lvluptemplate.resources.DummyData

@Composable
fun MainScreen(navController: NavController) {

    Scaffold(
        bottomBar = {
            NavBar(navController)
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(padding)
                .padding(16.dp)
        ) {

            // TÍTULO
            Text(
                text = "LvlUP",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            // SECCIÓN 1
            Text(
                text = "From your favorite artists",
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items(DummyData.allSongs.take(4)) { song ->

                    SongCard(song) {
                        navController.navigate("song/${song.title}/${song.artist}")
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // SECCIÓN
            Text(
                text = "New Music",
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items(DummyData.allSongs.drop(4).take(4)) { song ->

                    SongCard(song) {
                        navController.navigate("song/${song.title}/${song.artist}")
                    }
                }
            }
        }
    }
}
