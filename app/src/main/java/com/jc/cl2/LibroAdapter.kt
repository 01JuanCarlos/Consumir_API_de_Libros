package com.jc.cl2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jc.cl2.database.Libro

class LibroAdapter(val mItemClickListener: ItemClickListener):
    RecyclerView.Adapter<LibroViewHolder>()  {

    private var librolist= emptyList<Libro>()

    fun setLibro(libro:List<Libro>){
        this.librolist=libro
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return LibroViewHolder(inflater, parent)
        }

        override fun getItemCount(): Int {
            return librolist.size
        }

        override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
            val libro: Libro = librolist[position]
            holder.bind(libro)
            holder.itemView.setOnClickListener{
                mItemClickListener.onItemClick(libro)
            }
        }

    interface ItemClickListener{
        fun onItemClick(libro:Libro)
    }

}