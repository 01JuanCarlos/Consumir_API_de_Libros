package com.jc.cl2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jc.cl2.database.Libro

class LibroActivity: AppCompatActivity(),LibroAdapter.ItemClickListener {

    private lateinit var libroViewModel: LibroViewModel;

    private var ListaCategoria: Spinner?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)

        ListaCategoria=findViewById(R.id.categorias)
        val listaCategoria= arrayOf("Categorias","Drama","Narrativo","lirico","didactico")
        var adaptador: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaCategoria)
        ListaCategoria?.adapter=adaptador

//////////////////////
        libroViewModel=run {
            ViewModelProvider(this)[LibroViewModel::class.java]
        }

        val textCodigo = findViewById<EditText>(R.id.txtCodigo)
        val textNombre = findViewById<EditText>(R.id.txtNombre)
        val textAutor = findViewById<EditText>(R.id.txtAutor)

        val btnRegis = findViewById<Button>(R.id.btn_registrar)
        btnRegis.setOnClickListener {
            alertWithDesignCustom()
            var nombre = textNombre.text.toString()
            val codigo = textCodigo.text.toString().toInt()
            val autor =textAutor.text.toString()
            var libro=Libro(codigo,nombre,autor)

            libroViewModel.savelibroWithCoroutines(libro)
            textCodigo.setText("")
            textNombre.setText("")
            textAutor.setText("")
        }


////////////////
        val recyclerLibros = findViewById<RecyclerView>(R.id.recyclerLibros)
        val adapter= LibroAdapter(this)
        recyclerLibros.adapter=adapter
        recyclerLibros.layoutManager= LinearLayoutManager(this)

        libroViewModel.libros?.observe(this){ libros->
            libros?.let{
                adapter.setLibro(libros)
            }
        }




}


    fun alertWithDesignCustom() {

        val builder = AlertDialog.Builder(this)


        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.alert, null)
        builder.setView(dialogLayout)


        val btnAceptar = dialogLayout.findViewById<Button>(R.id.btnAceptar)

        val mAlertDialog = builder.show()

        btnAceptar.setOnClickListener {


            mAlertDialog.dismiss()
        }
    }
    override fun onItemClick(libro: Libro) {
        TODO("Not yet implemented")
    }
}