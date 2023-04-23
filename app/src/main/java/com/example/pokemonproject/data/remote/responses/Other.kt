package com.example.pokemonproject.data.remote.responses


import com.example.pokemonproject.data.remote.responses.DreamWorld
import com.example.pokemonproject.data.remote.responses.OfficialArtwork
import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorld,
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork
)