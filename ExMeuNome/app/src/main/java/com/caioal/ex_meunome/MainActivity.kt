package com.caioal.ex_meunome

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNome.setOnClickListener {
            val nome = edTxtNome.text

            txtMeuNome.text = getString(R.string.meu_nome)
            txtNome.text = nome


        }
    }


}