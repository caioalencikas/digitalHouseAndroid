package com.caioal.extemperatura

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnTemp.setOnClickListener {
            val tempCelsius: Int = edTemp.getText().toString().toInt()

            val tempFar = ((tempCelsius * 9) / 5) + 32

            txtTemp.text = "$tempFar ºF"


        }
    }

}