package com.example.lvluptemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.*

import com.example.lvluptemplate.screen.MainScreen
import com.example.lvluptemplate.screen.SearchScreen
import com.example.lvluptemplate.screen.SongScreen
import com.example.lvluptemplate.screen.PlaylistScreen
import com.example.lvluptemplate.screen.MyPlaylistScreen

import com.example.lvluptemplate.ui.theme.LvlUPTemplateTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            LvlUPTemplateTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "main"
                ) {

                    //  MAIN
                    composable("main") {
                        MainScreen(navController)
                    }

                    //  SEARCH
                    composable("search") {
                        SearchScreen(navController)
                    }

                    //  SONG DETAIL
                    composable("song/{title}/{artist}") { backStackEntry ->

                        val title = backStackEntry.arguments?.getString("title") ?: ""
                        val artist = backStackEntry.arguments?.getString("artist") ?: ""

                        SongScreen(title, artist, navController)
                    }

                    //  PLAYLIST LIST
                    composable("playlistScreen") {
                        PlaylistScreen(navController)
                    }

                    //  PLAYLIST DETAIL
                    composable("playlist/{name}") { backStackEntry ->

                        val name = backStackEntry.arguments?.getString("name") ?: ""

                        MyPlaylistScreen(name, navController)
                    }
                }
            }
        }
    }
}