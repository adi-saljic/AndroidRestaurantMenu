package com.example.menu.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.menu.R
import com.example.menu.models.Recipe
import com.example.menu.viewmodel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_add_recipe.*
import kotlinx.android.synthetic.main.fragment_add_recipe.view.*

class AddRecipeFragment : Fragment() {

    private lateinit var mRecipeViewModel : RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_recipe, container, false)

        mRecipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        view.add_new_recipe.setOnClickListener{
            insertData()
        }

        return view
    }

    private fun insertData() {
        val name = name_input.text.toString()
        val category = category_input.text.toString()
        val desc = desc_input.text.toString()
        val ingredients =  ingredients_input.text.toString()


        if(inputCheck(name,category, ingredients, desc)){
            val recipe = Recipe(0,name,category,ingredients, desc)
            mRecipeViewModel.addRecipe(recipe)
            Toast.makeText(requireContext(),"Successfully added!",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addRecipeFragment_to_recipeFragment)
        }else{
            Toast.makeText(requireContext(),"Some fields are empty!",Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(name: String, category: String, ingredients: String, desc: String ):Boolean{
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(category) || TextUtils.isEmpty(ingredients) || TextUtils.isEmpty(desc) ){
            return false
        }
        return true
    }
}