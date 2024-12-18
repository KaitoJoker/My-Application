package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class LoadImageURL : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_image_url)

        val gambarUtama : ImageView = findViewById(R.id.gambarUtama)
        val url = "https://sportshub.cbsistatic.com/i/2022/11/13/4bbfb030-55a8-4158-bd36-86b099a5b6d9" +
                "/pokemon-journeys-ash-world-champion-trophy.jpg?width=1200"
        Picasso.get().load(url).resize(650,850).centerCrop().into(gambarUtama)
    }
}