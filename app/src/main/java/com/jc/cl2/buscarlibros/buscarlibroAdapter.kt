package com.jc.cl2.buscarlibros

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jc.cl2.network.response.books

class buscarlibroAdapter (val list: ArrayList<books>):
    RecyclerView.Adapter<buscarlibroViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): buscarlibroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return buscarlibroViewHolder(inflater, parent)    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: buscarlibroViewHolder, position: Int) {
        val libro: books = list[position]
        holder.bind(libro)    }


}