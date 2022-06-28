package com.example.menu.data

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.menu.models.PizzaBase

@Dao
interface PizzaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPizza(pizzaItem: PizzaBase)

    @Query("SELECT * FROM pizza_table")
    fun readAllFavs():LiveData<List<PizzaBase>>

    @Delete
    fun deleteFav(pizzaItem: PizzaBase)

    @Query("DELETE FROM pizza_table")
    fun deleteAllFavs()
}