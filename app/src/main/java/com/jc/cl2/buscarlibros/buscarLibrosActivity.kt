package com.jc.cl2.buscarlibros

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jc.cl2.R
import com.jc.cl2.network.response.books

class buscarLibrosActivity:AppCompatActivity() {



    private val listalii: ArrayList<books> = ArrayList<books>().apply {
        add(books("hawaiana pizza", "Exquisita com", "fd", "fdfd", "fdfd"))
    }

    private lateinit var viewModel: burscarLibrosViewModel
    private lateinit var listalibros: ArrayList<books>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busqueda)

        listalibros = ArrayList()
        viewModel = run {
            ViewModelProvider(this)[burscarLibrosViewModel::class.java]
        }

        val btnBuscar= findViewById<Button>(R.id.btnbuscar)
        val txttitle=findViewById<TextView>(R.id.txttitle)


        btnBuscar.setOnClickListener {
            val title = txttitle.text.toString()
            println(title)
            viewModel.libro(title)

            val recyclerNews = findViewById<RecyclerView>(R.id.recyclerbuscarlibros)
            recyclerNews.apply {
                // layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                // layoutManager = GridLayoutManager(context, 2)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = buscarlibroAdapter(listalibros)
                println("Activity :"+listalibros.size)

            }
        }

        viewModel.libroListService.observe(this) {
            listalibros=it
            for (elemento in listalibros) {
                println(elemento)
            }
        }






    }


}