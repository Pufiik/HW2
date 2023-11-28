package ru.pugovishnikova.example.hw2

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ItemApi {

    @GET("/v1/gifs/trending")
    suspend fun getTrendingGifs(
        @Header("X-RapidAPI-Key") key: String = KEY_STR,
        @Header("X-RapidAPI-Host") host: String = HOST_STR,
        @Query("api_key") apiKey: String = API_KEY_STR
    ): GifsResponse

    companion object {
        const val KEY_STR = "d7b94ca990msh8676334353fe1c9p1dc8a4jsnb87eec86726a"
        const val HOST_STR = "giphy.p.rapidapi.com"
        const val API_KEY_STR = "fXPzt5bNbYQyD8kV0FAdugvymXj0ajb4"
    }
}