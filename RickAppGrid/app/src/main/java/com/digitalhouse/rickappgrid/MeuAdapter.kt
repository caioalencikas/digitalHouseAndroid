package com.digitalhouse.rickappgrid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickappgrid.api.Personagem
import com.squareup.picasso.Picasso

class MeuAdapter(private val dataSet: List<Personagem>, private val listener: (Personagem) -> Unit): RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val image: ImageView = view.findViewById(R.id.imgVw)
        private val name: TextView = view.findViewById(R.id.txtName)
        private val specie: TextView = view.findViewById(R.id.txtSpecie)

        fun bind(personagem: Personagem) {

            name.text = personagem.nome
            specie.text = personagem.especie

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
        val item = dataSet[position]
        holder.bind(item)

        holder.itemView.setOnClickListener { listener(item) }
    }

}