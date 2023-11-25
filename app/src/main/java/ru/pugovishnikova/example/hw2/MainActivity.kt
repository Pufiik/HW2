package ru.pugovishnikova.example.hw2

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {

    lateinit var iv: ImageView
    val url = "https://www.google.ru/url?sa=i&url=https%3A%2F%2Ftenor.com%2Fview%2Fmonkey-funny-hewwoooo-gif-24803889&psig=AOvVaw3NhXB_pNfpA8DOwNqsOApG&ust=1701019389213000&source=images&cd=vfe&opi=89978449&ved=0CA8QjRxqFwoTCMjerbPV34IDFQAAAAAdAAAAABAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}