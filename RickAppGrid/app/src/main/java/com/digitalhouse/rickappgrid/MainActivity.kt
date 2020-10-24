package com.digitalhouse.rickappgrid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickappgrid.api.IRespostaDaApi
import com.digitalhouse.rickappgrid.api.Personagem
import com.digitalhouse.rickappgrid.api.RickApi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        RickApi.getData(this, object :
            IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                criarLista(personagens)
            }
        })
    }

    fun criarLista(personagens: List<Personagem>) {
        val viewManager = GridLayoutManager(this,2)
        val recyclerView = findViewById<RecyclerView>(R.id.myList)

        val viewAdapter = MeuAdapter(personagens) { personagem ->
            //Toast.makeText(this, personagem.nome, Toast.LENGTH_LONG).show()
            val intent = Intent(this@MainActivity, CharacterActivity::class.java)
            intent.putExtra("Imagem", personagem.imagemUrl)
            intent.putExtra("Name", personagem.nome)
            intent.putExtra("Gender", personagem.genero)
            intent.putExtra("Planet", personagem.localizacao.nome)

            startActivity(intent)

        }

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter

            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}