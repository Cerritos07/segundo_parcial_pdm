package com.example.lvluptemplate.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun SongScreen(
    title: String,
    artist: String,
    navController: NavController
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        //  VOLVER
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        //  INFO
        Text(
            text = title,
            color = Color.White,
            fontSize = 24.sp
        )

        Text(
            text = "By $artist",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            Toast.makeText(context, "Reproduciendo", Toast.LENGTH_SHORT).show()
        }) {
            Icon(Icons.Default.PlayArrow, contentDescription = "")
            Text("Play")
        }
    }
}
