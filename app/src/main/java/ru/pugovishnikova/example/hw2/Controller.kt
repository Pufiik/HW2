package ru.pugovishnikova.example.hw2

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Controller {

    val scope = CoroutineScope(Dispatchers.IO)

    private val client = Retrofit.Builder()
        .baseUrl("https://giphy.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //отправка запроса

    private fun requireService() = client.create(ItemApi::class.java)

    fun loadData(callback: (result: GifsResponse?, error: Throwable?) -> Unit) {

        scope.launch {
            try {
                val result = requireService().getTrendingGifs()
                withContext(Dispatchers.Main) {
                    callback(result, null)
                }

            } catch (e: Throwable) {
                withContext(Dispatchers.Main) {
                    callback(null, e)
                }
            }
        }
    }

}