package com.example.menu.repository

import androidx.lifecycle.LiveData
import com.example.menu.data.PizzaDao
import com.example.menu.models.PizzaBase


class PizzaRepository(private val pizzaDao: PizzaDao) {

    val readAllFavs : LiveData<List<PizzaBase>> = pizzaDao.readAllFavs()

    fun addPizza(pizzaItem: PizzaBase){
        pizzaDao.addPizza(pizzaItem)
    }


    fun deleteFav(pizzaItem: PizzaBase){
        pizzaDao.deleteFav(pizzaItem)
    }

    fun deleteAllFavs(){
        pizzaDao.deleteAllFavs()
    }

}