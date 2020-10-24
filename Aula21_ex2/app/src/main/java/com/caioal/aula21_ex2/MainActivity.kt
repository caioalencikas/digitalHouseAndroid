package com.caioal.aula21_ex2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_b.*
import java.util.*

class MainActivity : AppCompatActivity(), ICalcular {

    var fragA = FragmentA()
    var fragB = FragmentB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val manager = supportFragmentManager

        val transactionA = manager.beginTransaction()
        transactionA.add(R.id.fragmentA, fragA)
        transactionA.commit()


        val transactionB = manager.beginTransaction()
        transactionB.add(R.id.fragmentB, fragB)
        transactionB.commit()
    }

    override fun calcular(nome: String, anoNasc: Int) {
        super.calcular(nome, anoNasc)

        val atual = Calendar.getInstance().get(Calendar.YEAR)
        val idade = atual - anoNasc

        if (idade <= 0) {
            fragB.txtVwIdade.text = "$nome ainda não nasceu"
        } else if (idade == 1) {
            fragB.txtVwIdade.text = "$nome você tem $idade ano."
        } else {
            fragB.txtVwIdade.text = "$nome você tem $idade anos."
        }
    }

}