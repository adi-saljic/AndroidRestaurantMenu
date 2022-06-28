package com.example.menu.repository

import androidx.lifecycle.LiveData
import com.example.menu.data.RecipeDao
import com.example.menu.models.Recipe

class RecipeRepository(private val recipeDao: RecipeDao) {

    val readAllData : LiveData<List<Recipe>> = recipeDao.readAllData()

    fun addRecipe(recipe: Recipe){
        recipeDao.addRecipe(recipe)
    }

    fun updateRecipe(recipe: Recipe){
        recipeDao.updateRecipe(recipe)
    }

    fun deleteRecipe(recipe: Recipe){
        recipeDao.deleteRecipe(recipe)
    }

    fun deleteAll(){
        recipeDao.deleteAll()
    }


}