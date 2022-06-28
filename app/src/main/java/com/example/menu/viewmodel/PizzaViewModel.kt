package com.example.menu.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.menu.data.PizzaDatabase
import com.example.menu.models.PizzaBase
import com.example.menu.repository.PizzaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaViewModel(application: Application):AndroidViewModel(application) {
    val readAllFavs : LiveData<List<PizzaBase>>
    private val repository : PizzaRepository

    init{
        val pizzaDao = PizzaDatabase.getDatabase(application).pizzaDao()
        repository = PizzaRepository(pizzaDao)
        readAllFavs = repository.readAllFavs
    }

    fun addPizza(pizzaItem: PizzaBase){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPizza(pizzaItem)
        }
    }

    fun deleteRecipe(pizzaItem: PizzaBase){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFav(pizzaItem)
        }
    }

    fun deleteAllFavs(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllFavs()
        }
    }

}