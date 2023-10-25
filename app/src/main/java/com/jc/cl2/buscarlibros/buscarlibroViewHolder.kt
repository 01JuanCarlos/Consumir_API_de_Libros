package com.jc.cl2.buscarlibros

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jc.cl2.R
import com.jc.cl2.network.response.books

class buscarlibroViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(
    R.layout.item_busqueda, parent, false)) {


    private var txtNombre: TextView? = null
    private var textDescripcion: TextView? = null
    private var textPrecio: TextView? = null

    init {
        textDescripcion = itemView.findViewById(R.id.buscardescripcion)
        txtNombre = itemView.findViewById(R.id.buscarNombre)
        textPrecio=itemView.findViewById(R.id.buscarprecio)
    }

    fun bind(libro:books) {
        textDescripcion?.text = libro.descripcion
        txtNombre?.text=libro.nombre
        textPrecio?.text=libro.precio
    }
}