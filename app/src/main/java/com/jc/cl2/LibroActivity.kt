package com.jc.cl2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class LibroActivity: AppCompatActivity() {


    private var ListaCategoria: Spinner?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)

        ListaCategoria=findViewById(R.id.categorias)
        val listaCategoria= arrayOf("Seleccione","Desayuno","Almuerzos","Postres","Bebidas")
        var adaptador: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaCategoria)
        ListaCategoria?.adapter=adaptador

}
}