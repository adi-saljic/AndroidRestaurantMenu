package com.example.menu.data

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.menu.models.Recipe

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addRecipe(recipe: Recipe)

    @Query("SELECT * FROM recipe_table ORDER BY name ASC")
    fun readAllData():LiveData<List<Recipe>>

    @Update
    fun updateRecipe(recipe: Recipe)

    @Delete
    fun deleteRecipe(recipe: Recipe)

    @Query("DELETE FROM recipe_table")
    fun deleteAll()
}