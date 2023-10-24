package com.jc.cl2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.jc.cl2.database.Libro
import kotlinx.coroutines.launch

class LibroViewModel (application: Application): AndroidViewModel(application){

    private val repository = LibroRepository(application)

    val libros = repository.getLibro()

    fun savelibroWithCoroutines(libro: Libro) {
        viewModelScope.launch {
            repository.insetLibroWithCorovtines(libro)
        }
    }

    fun upatelibroWithCoroutines(libro: Libro) {
        viewModelScope.launch {
            repository.updateLibroWithCoroutines(libro)
        }
    }


}