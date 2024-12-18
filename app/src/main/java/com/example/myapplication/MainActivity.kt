package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        fun daduUrut(angka: Int, gambar: ImageView): Int{
            Log.i("info", "daduUrut: $angka")
            val hasil = angka +1
            val gambarId = resources.getIdentifier("dadu$hasil", "drawable", packageName)
            gambar.setImageDrawable(getDrawable(gambarId))
            return if (angka<5) hasil else 0

        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textLabel = this.findViewById<TextView>(R.id.labelNama)
        textLabel.setText("STMIK Jayakarta")
        textLabel.textSize = 25f
        textLabel.setTextColor(getColor(R.color.white))

        val labelHobby: TextView = findViewById(R.id.labelHobby)
        labelHobby.setText("Pemrograman Mobile")
        labelHobby.textSize = 25f
        labelHobby.setTextColor(getColor(R.color.white))

        val tombolGanti: Button = findViewById(R.id.tombolGanti)
        val gambar: ImageView = findViewById(R.id.gambar1)
        val tombolReset: Button = findViewById(R.id.tombolReset)
        val tombolUrut: Button = findViewById(R.id.urutDadu)
        val tombolPindahKalkulator : Button = findViewById(R.id.kalkulator)
        val tombolPindahListMovie : Button = findViewById(R.id.listMovie)
        var angka = 0

        tombolReset.setOnClickListener(View.OnClickListener {
            gambar.setImageDrawable(getDrawable(R.drawable.dadu))
        })

        tombolUrut.setOnClickListener(View.OnClickListener {
            angka = daduUrut(angka,gambar)
        })

        tombolGanti.setOnClickListener(View.OnClickListener{
            var hitung = (1 .. 6).random()
            Log.i("info", "onCreate: $hitung")
            when(hitung){
                1 -> {
                    gambar.setImageDrawable(getDrawable(R.drawable.dadu1))
                    //hitung = (1 .. 6).random()
                }
                2 -> {
                    gambar.setImageDrawable(getDrawable(R.drawable.dadu2))
                    //hitung = (1 .. 6).random()
                }
                3 -> {
                    gambar.setImageDrawable(getDrawable(R.drawable.dadu3))
                    //hitung = (1 .. 6).random()
                }
                4 -> {
                    gambar.setImageDrawable(getDrawable(R.drawable.dadu4))
                    //hitung = (1 .. 6).random()
                }
                5 -> {
                    gambar.setImageDrawable(getDrawable(R.drawable.dadu5))
                    //hitung = (1 .. 6).random()
                }
                6 -> {
                    gambar.setImageDrawable(getDrawable(R.drawable.dadu6))
                    //hitung = (1 .. 6).random()
                }
                else -> gambar.setImageDrawable(getDrawable(R.drawable.charizard))
            }

        })

        tombolPindahKalkulator.setOnClickListener {
            val intent = Intent(this@MainActivity, kalkulator::class.java)
            intent.putExtra("pesanPindahHalaman", "pindah ke halaman kalkulator")
            startActivity(intent)
            val pesan = intent.getStringExtra("pesanPindahHalaman")
            Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
        }

        tombolPindahListMovie.setOnClickListener {
            val intent = Intent(this@MainActivity, ListMovies::class.java)
            intent.putExtra("pesanPindahHalaman", "pindah ke halaman list movies")
            startActivity(intent)
            val pesan = intent.getStringExtra("pesanPindahHalaman")
            Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
        }
    }
}