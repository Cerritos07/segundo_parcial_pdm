package com.example.lvluptemplate.resources

import androidx.compose.runtime.mutableStateListOf

data class SongEntity(
    val id: String,
    val title: String,
    val artist: String,
    val album: String,
    val cover: String,
    val genreId: String
)

data class PlaylistEntity(
    val id: String,
    val name: String,
    val description: String
)

object DummyData {

    val allSongs = listOf(

        // Indie / vibes suaves
        SongEntity("s1", "Blamegame", "NSQK", "ATP", "", "g5"),
        SongEntity("s2", "309", "NSQK", "Bótanica", "", "g5"),
        SongEntity("s3", "Eclipse", "Luna Grey", "After Hours", "", "g5"),

        // Chill / R&B  c
        SongEntity("s4", "Golden Night", "Arden Miles", "Midnight Stories", "", "g1"),
        SongEntity("s5", "Stay Close", "Keshi", "Echoes", "", "g5"),

        // Pop moderno
        SongEntity("s6", "Out of Time", "The Weeknd", "Dawn FM", "", "g3"),
        SongEntity("s7", "Lights Down Low", "Max Nova", "City Lights", "", "g3"),

        // Latino urbano
        SongEntity("s8", "Aguacero", "Bad Bunny", "UVST", "", "g2"),
        SongEntity("s9", "Flow Callejero", "DJ Pulse", "Neon Beats", "", "g2"),

        // Electrónica
        SongEntity("s10", "Digital Love", "Electra", "Synth World", "", "g4"),
        SongEntity("s11", "Night Drive", "Neon Waves", "Cyber City", "", "g4"),

        // Mix
        SongEntity("s12", "Lost Memories", "Evan Hart", "Fragments", "", "g3"),
        SongEntity("s13", "Velvet Sky", "Iris Moon", "Dreamscape", "", "g1")
    )

    // PARTE 5 (PARCIAL)
    val favoriteSongs = mutableStateListOf<SongEntity>()

}
