package com.example.menu.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.menu.models.PizzaBase

@Database(entities = [PizzaBase::class], version = 1, exportSchema = false)
abstract class PizzaDatabase:RoomDatabase() {

    abstract fun pizzaDao() : PizzaDao

    companion object {
        @Volatile
        private var INSTANCE : PizzaDatabase? = null

        fun getDatabase(context : Context): PizzaDatabase{
            val tempInstance = PizzaDatabase.INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PizzaDatabase::class.java,
                    "pizza_database"
                ).build()
                PizzaDatabase.INSTANCE = instance
                return instance
            }
        }
    }


}