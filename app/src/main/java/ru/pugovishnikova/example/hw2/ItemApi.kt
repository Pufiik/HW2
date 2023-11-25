package ru.pugovishnikova.example.hw2

import retrofit2.Response
import retrofit2.http.*

interface ItemApi {
    @GET("item/random")
    suspend fun item(): Response<Item>
}