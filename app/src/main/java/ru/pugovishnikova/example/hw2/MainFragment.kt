package ru.pugovishnikova.example.hw2

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment: Fragment(R.layout.main_fragment) {
    lateinit var iv: ImageView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRetainInstance(true)
    }

    override fun onResume() {
        super.onResume()
        val recycler = view?.findViewById<RecyclerView>(R.id.image_rv)
        val progress = view?.findViewById<FrameLayout>(R.id.progress_bar)
        recycler?.layoutManager = LinearLayoutManager(context)
        Controller.loadData { result, error ->
                progress?.isVisible = false
                when {
                    result != null -> {
                        val images = result.data.map { it.images }
                        val adapter = GifAdapter(images)
                        recycler?.adapter = adapter
                    }

                    error != null -> {
                        Toast.makeText(
                            context,
                            "Во время выполнения запроса возникла ошибка: $error",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }


    }
}