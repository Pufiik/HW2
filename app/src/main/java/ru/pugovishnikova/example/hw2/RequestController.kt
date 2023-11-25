package ru.pugovishnikova.example.hw2

import com.google.gson.annotations.SerializedName
interface RequestController {
    suspend fun requestItem(): Result
}

sealed interface Result{
    data class Ok(val item: Item): Result
    data class Error(val error: String): Result
}

data class Item(
    @SerializedName("name") val name: String,
    @SerializedName("link") val link: String
)

