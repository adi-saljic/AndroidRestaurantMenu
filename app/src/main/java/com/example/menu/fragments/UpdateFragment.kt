package com.example.menu.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.menu.R
import com.example.menu.models.Recipe
import com.example.menu.viewmodel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mRecipeViewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        mRecipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        view.name_input_update.setText(args.currentRecipe.name)
        view.category_input_update.setText(args.currentRecipe.category)
        view.ingredients_input_update.setText(args.currentRecipe.ingredients)
        view.desc_input_update.setText(args.currentRecipe.desc)

        view.update_recipe.setOnClickListener{
            updateRecipe()
        }

        setHasOptionsMenu(true)

        return view
    }

    private fun updateRecipe() {
        val name = name_input_update.text.toString()
        val cat = category_input_update.text.toString()
        val ing = ingredients_input_update.text.toString()
        val desc = desc_input_update.text.toString()

        val updatedRecipe = Recipe(args.currentRecipe.id,name,cat,ing, desc)
        mRecipeViewModel.updateRecipe(updatedRecipe)
        findNavController().navigate(R.id.action_updateFragment_to_recipeFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mRecipeViewModel.deleteRecipe(args.currentRecipe)
            Toast.makeText(requireContext(), "Successfuly deleted!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_recipeFragment)
        }

        builder.setNegativeButton("No"){_,_ ->}
        builder.setTitle("Delete ${args.currentRecipe.name}?")
        builder.setMessage("Are you sure you want to delete ${args.currentRecipe.name} from category ${args.currentRecipe.category}?")
        builder.create().show()
    }
}