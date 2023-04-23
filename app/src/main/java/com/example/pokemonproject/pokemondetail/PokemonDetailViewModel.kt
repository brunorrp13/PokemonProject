package com.example.pokemonproject.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.pokemonproject.data.remote.responses.Pokemon
import com.example.pokemonproject.repository.PokemonRepository
import com.example.pokemonproject.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}