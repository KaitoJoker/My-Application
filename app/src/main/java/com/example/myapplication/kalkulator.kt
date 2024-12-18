package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class kalkulator : AppCompatActivity(){
    /**
     * mendeklarisikan variabel beserta type object
     */
    private lateinit var textKalkulasi: TextView
    private lateinit var textHasil: TextView
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnAC: Button
    private lateinit var btnC: Button
    private lateinit var btnTitik: Button
    private lateinit var btnKoma: Button
    private lateinit var btnTambah: Button
    private lateinit var btnKurang: Button
    private lateinit var btnKali: Button
    private lateinit var btnBagi: Button
    private lateinit var btnHapus: Button
    private lateinit var btnSamaDengan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)
        /**
         * memasukan nilai ke dalam variabel yang sudah di deklarasikan
         */
        btn0 = findViewById(R.id.butonNol)
        btn1 = findViewById(R.id.butonSatu)
        btn2 = findViewById(R.id.butonDua)
        btn3 = findViewById(R.id.butonTiga)
        btn4 = findViewById(R.id.butonEmpat)
        btn5 = findViewById(R.id.butonLima)
        btn6 = findViewById(R.id.butonEnam)
        btn7 = findViewById(R.id.butonTujuh)
        btn8 = findViewById(R.id.butonDelapan)
        btn9 = findViewById(R.id.butonSembilan)
        btnAC = findViewById(R.id.butonAC)
        btnC = findViewById(R.id.butonC)
        btnHapus = findViewById(R.id.butonHapus)
        btnTitik = findViewById(R.id.butonTitik)
        btnKoma = findViewById(R.id.butonKoma)
        btnSamaDengan = findViewById(R.id.butonSamaDengan)
        btnTambah = findViewById(R.id.butonTambah)
        btnKurang = findViewById(R.id.butonKurang)
        btnKali = findViewById(R.id.butonKali)
        btnBagi = findViewById(R.id.butonBagi)
        textKalkulasi = findViewById(R.id.textView1)
        textHasil= findViewById(R.id.textView2)
        val btnKembali: Button = findViewById(R.id.kembaliDadu)

        textKalkulasi.textSize = 60f
        textKalkulasi.movementMethod = ScrollingMovementMethod()
        textKalkulasi.isActivated = true
        textKalkulasi.isPressed = true
        textHasil.textSize = 50f
        textHasil.movementMethod = ScrollingMovementMethod()
        textHasil.isActivated = true
        textHasil.isPressed = true

        var huruf: String

        /**
         * membuat fungsi onclick di variabel type Button
         */
       btn0.setOnClickListener {
           angkaSize()
           buttonText("0")
           result()

       }

        btn1.setOnClickListener {
            angkaSize()
            buttonText("1")
            result()
        }

        btn2.setOnClickListener {
            angkaSize()
            buttonText("2")
            result()
        }

        btn3.setOnClickListener {
            angkaSize()
            buttonText("3")
            result()
        }

        btn4.setOnClickListener {angkaSize()
            buttonText("4")
            result()
        }

        btn5.setOnClickListener {
            angkaSize()
            buttonText("5")
            result()
        }

        btn6.setOnClickListener {
            angkaSize()
            buttonText("6")
            result()
        }

        btn7.setOnClickListener {
            angkaSize()
            buttonText("7")
            result()
        }

        btn8.setOnClickListener {
            angkaSize()
            buttonText("8")
            result()
        }

        btn9.setOnClickListener {
            angkaSize()
            buttonText("9")
            result()
        }

        btnTitik.setOnClickListener {
            angkaSize()
            operatorText(".")
        }

        btnKoma.setOnClickListener {
            angkaSize()
            operatorText(",")
        }

        btnKali.setOnClickListener {
            angkaSize()
            operatorText("*")
        }

        btnBagi.setOnClickListener {
            angkaSize()
            operatorText("/")
        }

        btnTambah.setOnClickListener {
            angkaSize()
            operatorText("+")
        }

        btnKurang.setOnClickListener {
            angkaSize()
            operatorText("-")
        }

        btnHapus.setOnClickListener {
            angkaSize()
            // handling error
            try {
                // membuat fungsi delete berdasarkan lastIndex
                if (textKalkulasi.text.toString().isNotEmpty() || textHasil.text.toString().isNotEmpty()){
                    val lastIndex = textKalkulasi.text.toString().lastIndex
                    val str = textKalkulasi.text.toString().substring(0, lastIndex)
                    kalkulasi(str)
                    result()
                }
            }catch (e: Exception){
                kalkulasi("")
                hasil("")
                result()
            }
        }

        btnAC.setOnClickListener {
            angkaSize()
            kalkulasi("")
            hasil("")
        }


        btnC.setOnClickListener {
            angkaSize()
            kalkulasi("")
            hasil("")
        }

        btnSamaDengan.setOnClickListener {
            textKalkulasi.textSize = 50f
            textHasil.textSize = 60f
            result()
        }

        btnKembali.setOnClickListener {
            // Membuat Intent untuk pindah berdasarkan activity
            val intent = Intent(this@kalkulator, MainActivity::class.java)
            intent.putExtra("pesanPindahHalaman", "pindah ke halaman dadu")
            startActivity(intent)
            val pesan = intent.getStringExtra("pesanPindahHalaman")
            Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
        }

    }

    /**
     * Membuat Fungsi untuk di gunakan di tiap funsi onclick yang kita punya
     */
    // Membuat fungsi text pada textView1
    private fun kalkulasi(huruf: String) {
        textKalkulasi.text = huruf
    }
    // Membuat fungsi text pada textView2
    private fun hasil(huruf: String) {
        textHasil.text = huruf
    }
    // Membuat fungsi string untuk setiap tombol onclick
    private fun buttonText(angkaText: String){
        var text = textKalkulasi.text.toString()
        if (text.isNotEmpty()){
            var text0 = kalkulasi(text+angkaText)
        }else{
            kalkulasi(angkaText)
        }
    }
    // Membuat fungsi text size
    private fun angkaSize(){
        if (textKalkulasi.textSize < textHasil.textSize){
            textKalkulasi.textSize = 60f
            textHasil.textSize = 50f
        }else{
            textKalkulasi.textSize = 60f
            textHasil.textSize = 50f
        }
    }
    // Membuat fungsi operator untuk di evaluasi
    private fun operatorText(opText: String){
        if (textKalkulasi.text.toString().endsWith("x")||textKalkulasi.text.toString().endsWith("/")
            ||textKalkulasi.text.toString().endsWith("+")||textKalkulasi.text.toString().endsWith("-")
            ||textKalkulasi.text.toString().endsWith(".")
            ||textKalkulasi.text.toString().endsWith(",")){
            val text = textKalkulasi.text.toString()
            kalkulasi(text)
        }else{
            val text = textKalkulasi.text.toString()
            kalkulasi(text+opText)
        }
    }
    // Membuat fungsi hasil dengan menambahkan dependencies net.objecthunter:exp4j:0.4.8
    private fun result(){
        val text = textKalkulasi.text.toString()
        try {
            val resultInt = ExpressionBuilder(text).build().evaluate().toInt().toString()
            val resultKoma = ExpressionBuilder(text).build().evaluate().toString()
            if (resultKoma.endsWith(".0")){
                textHasil.text = "=$resultInt"
            }else{
                textHasil.text = "=$resultKoma"
            }
        }catch (e: Exception){
            textKalkulasi.text = textKalkulasi.text.toString()
            textHasil.text = textHasil.text.toString()
        }
    }
}