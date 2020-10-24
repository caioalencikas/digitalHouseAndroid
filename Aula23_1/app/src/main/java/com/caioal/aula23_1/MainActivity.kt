package com.caioal.aula23_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)
        val viewAdapter = MeuAdapter(arrayListOf(Item("Vader", "I am your father", "13:35")
                                    , Item("Yoda", "Do or do not", "14:40")
                                    ,Item("Obi-Wan", "Hello there", "18:50")))

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter

            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        }
    }
}