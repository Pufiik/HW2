package ru.pugovishnikova.example.hw2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class Controller(api: String): RequestController {
    private val retrofit = Retrofit.Builder()
        .baseUrl(api)
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()

        private val itemApi = retrofit.create(ItemApi::class.java)
        override suspend fun requestItem(): Result {
            val response = itemApi.item()
            return if (response.isSuccessful){
                response.body()?.let{
                    Result.Ok(it)
                }?:Result.Error("Empty item")
            } else {
                Result.Error(response.code().toString())
            }
        }
}