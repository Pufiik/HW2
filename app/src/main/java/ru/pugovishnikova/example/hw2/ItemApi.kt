package ru.pugovishnikova.example.hw2

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ItemApi {

    @GET("/v1/gifs/trending")
    suspend fun getTrendingGifs(
        @Header("X-RapidAPI-Key") key: String = "d7b94ca990msh8676334353fe1c9p1dc8a4jsnb87eec86726a",
        @Header("X-RapidAPI-Host") host: String = "giphy.p.rapidapi.com",
        @Query("api_key") apiKey: String = "fXPzt5bNbYQyD8kV0FAdugvymXj0ajb4"
    ): GifsResponse
}