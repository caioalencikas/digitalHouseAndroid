package com.caioal.exsalariohora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener{
            val horasTrabalhadas = edtHoraTrabalhada.text.toString().toInt()
            val valorHora = edtValorHora.text.toString().toInt()

            val salario = horasTrabalhadas * valorHora

            txtSalario.text = "R$ $salario"
        }
    }
}