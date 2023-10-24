package com.jc.cl2

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jc.cl2.database.Libro


class LibroViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(
        R.layout.item_libro, parent, false)){

    private var textNombre: TextView? = null
    private var textAutor: TextView? = null
    private var textcodigo: TextView? = null



    init {
        textNombre = itemView.findViewById(R.id.itemTxtNombre)
        textAutor  = itemView.findViewById(R.id.itemTxtAutor)
        textcodigo = itemView.findViewById(R.id.itemTxtCodigo)
    }

    fun bind(libro: Libro) {
        textcodigo?.text =libro.codigo.toString()
        textNombre?.text=libro.nombre
        textAutor?.text=libro.autor

    }

}