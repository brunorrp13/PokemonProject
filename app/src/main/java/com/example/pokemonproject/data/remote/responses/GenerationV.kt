package com.example.pokemonproject.data.remote.responses


import com.example.pokemonproject.data.remote.responses.BlackWhite
import com.google.gson.annotations.SerializedName

data class GenerationV(
    @SerializedName("black-white")
    val blackWhite: BlackWhite
)