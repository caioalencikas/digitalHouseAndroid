package com.example.chucknorris.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorris.R

class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val category = view.findViewById<TextView>(R.id.txtCategory)

    fun bind(categoryModel: String) {
        category.text = categoryModel
    }

}