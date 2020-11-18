package com.digitalhouse.rickapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem
import com.squareup.picasso.Picasso

class MeuAdapter(private val dataSet: List<Personagem>): RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val image: ImageView = view.findViewById(R.id.imgVw)
        private val name: TextView = view.findViewById(R.id.txtName)
        private val status: TextView = view.findViewById(R.id.txtStatus)
        private val type: TextView = view.findViewById(R.id.txtType)
        private val location: TextView = view.findViewById(R.id.txtLocation)
        private val locationName: TextView = view.findViewById(R.id.txtLocationName)

        fun bind(personagem: Personagem) {
            name.text = personagem.nome
            status.text = personagem.status
            type.text = personagem.especie
            locationName.text = personagem.localizacao.nome

            Picasso.get()
                .load(personagem.imagemUrl)
                .into(image)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MeuViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

}