package com.example.pokemonproject.data.remote

import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {

    private lateinit var service: PokemonApi
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPokemonCount(){
        runBlocking {
            enqueueMockResponse("pokemonresponse.json")
            val responseBody = service.getPokemonList(1,1)
            assertThat(responseBody.count).isEqualTo(1281)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("pokemonresponse.json")
            val responseBody = service.getPokemonList(1,1)
            val firstPokemon = responseBody.results[0]
            assertThat(firstPokemon.name).isEqualTo("bulbasaur")
            assertThat(firstPokemon.url).isEqualTo("https://pokeapi.co/api/v2/pokemon/1/")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}