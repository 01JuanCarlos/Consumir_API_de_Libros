package com.jc.cl2

import android.app.Application
import androidx.lifecycle.LiveData
import com.jc.cl2.database.DataBase
import com.jc.cl2.database.Libro
import com.jc.cl2.database.LibroDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LibroRepository (application: Application)  {

    private val librodao:LibroDAO?=
        DataBase.getInstance(application)?.librodao()

    suspend fun insetLibroWithCorovtines(libro:Libro){
        processInsertLibro(libro)
    }
    private  suspend fun processInsertLibro(libro:Libro){
        withContext(Dispatchers.Default){
            librodao?.insert(libro)
        }
    }



    suspend fun updateLibroWithCoroutines(libro:Libro) {
        processUpdateLibro(libro)
    }

    private suspend fun processUpdateLibro(libro:Libro) {
        withContext(Dispatchers.Default) {
            librodao?.update(libro)
        }
    }

    fun getLibro(): LiveData<List<Libro>>?{
        return librodao?.list()

    }
}