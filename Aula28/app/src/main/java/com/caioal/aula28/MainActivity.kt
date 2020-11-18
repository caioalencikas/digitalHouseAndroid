package com.caioal.aula28

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var _viewModel: ContadorViewModel

    private val _texto by lazy { findViewById<TextView>(R.id.txtTexto) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setudViewModel()
        setupUI()
    }

    private fun setudViewModel(){
        _viewModel = ViewModelProvider(
                this,
                ContadorViewModelFactory()
        ).get(ContadorViewModel::class.java)

        _viewModel.contador.observe(this, alterarTexto)
    }

    private val alterarTexto = Observer<Int> {
        _texto.text = it.toString()
    }

    private fun setupUI() {
        findViewById<Button>(R.id.btnContado).setOnClickListener {
            _viewModel.incrementar()
        }
    }


}