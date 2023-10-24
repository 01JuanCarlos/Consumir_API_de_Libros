package com.jc.cl2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface LibroDAO{
    @Insert
    fun insert(libro: Libro)

    @Update
    fun update(libro: Libro)

    @Delete
    fun delete(libro: Libro)

    @Query("SELECT * FROM tb_Libro ORDER BY codigo DESC")
    fun list(): LiveData<List<Libro>>
}
