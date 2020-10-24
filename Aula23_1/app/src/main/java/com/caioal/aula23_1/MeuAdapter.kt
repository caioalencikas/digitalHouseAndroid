package com.caioal.aula23_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeuAdapter(private val dataSet: List<Item>): RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val meuTexto:TextView = view.findViewById(R.id.txtNome)
        private val minhaMensagem:TextView = view.findViewById(R.id.txtMensagem)
        private val minhaHora:TextView = view.findViewById(R.id.txtHora)

        fun bind(item: Item) {
            meuTexto.text = item.nome
            minhaMensagem.text = item.ultimaMensagem
            minhaHora.text = item.hora
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)

        return MeuViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}