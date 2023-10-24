package com.jc.cl2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="tb_Libro")
data class Libro(
    @ColumnInfo("codigo")
    val codigo:Int,
    @ColumnInfo("nombre")
    val nombre:String,
    @ColumnInfo("Autor")
    val autor:String
){  @PrimaryKey(autoGenerate = true)
@ColumnInfo("id")
var id:Int=0

}

