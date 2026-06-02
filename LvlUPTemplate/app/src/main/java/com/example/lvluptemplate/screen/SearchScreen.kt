package com.example.lvluptemplate.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.lvluptemplate.components.SongResultRow
import com.example.lvluptemplate.components.NavBar
import com.example.lvluptemplate.resources.DummyData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {

    var searchQuery by remember { mutableStateOf("") }

    // ✅ FILTRO COMPLETO (incluye género)
    val filteredSongs = DummyData.allSongs.filter { song ->
        song.title.contains(searchQuery, true) ||
                song.artist.contains(searchQuery, true) ||
                song.album.contains(searchQuery, true) ||
                song.genreId.contains(searchQuery, true)
    }

    Scaffold(
        bottomBar = {
            NavBar(navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            // ✅ TÍTULO
            Text(
                text = "Search",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // ✅ BUSCADOR
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                placeholder = {
                    Text("Artists or songs...", color = Color.Gray)
                },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "", tint = Color.Gray)
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF151515),
                    unfocusedContainerColor = Color(0xFF151515),
                    focusedBorderColor = Color(0xFF7E49C3),
                    unfocusedBorderColor = Color(0xFF2C2C2C),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            //  RESULTADOS
            LazyColumn {

                items(filteredSongs) { song ->

                    SongResultRow(song) {
                        navController.navigate("song/${song.title}/${song.artist}")
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}
