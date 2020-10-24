package com.digitalhouse.rickappgrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class CharacterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        val image = intent.getStringExtra("Imagem")
        val name = intent.getStringExtra("Name")
        val gender = intent.getStringExtra("Gender")
        val planet = intent.getStringExtra("Planet")

        Picasso.get().load(image).into(findViewById<ImageView>(R.id.imgVwCharacter))

        findViewById<TextView>(R.id.txtNameCharacter).text = name
        findViewById<TextView>(R.id.txtGenderCharacter).text = gender
        findViewById<TextView>(R.id.txtPlanetCharacther).text = planet

    }
}