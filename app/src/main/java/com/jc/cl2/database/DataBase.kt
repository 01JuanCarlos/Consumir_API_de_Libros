package com.jc.cl2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities=[Libro::class], version=1)
abstract class DataBase: RoomDatabase() {

    abstract fun librodao():LibroDAO

    companion object{
        private const val DATABASE_NAME="db_CL2"
        @Volatile
        private  var INSTANCE:DataBase?=null

        fun getInstance(context: Context):DataBase?{
            INSTANCE?:synchronized(this){
                INSTANCE= Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}