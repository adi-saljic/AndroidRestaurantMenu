package com.example.menu.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menu.R
import com.example.menu.adapters.RecipeAdapter
import com.example.menu.viewmodel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_recipe.view.*

class RecipeFragment : Fragment() {

    private lateinit var mRecipeViewModel : RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_recipe, container, false)

        val adapter = RecipeAdapter()
        val recyclerView = view.recyclerview_recipe

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mRecipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)
        mRecipeViewModel.readAllData.observe(viewLifecycleOwner, Observer { recipe ->
            adapter.setData(recipe)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_recipeFragment_to_addRecipeFragment)
        }
        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteAll()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAll() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mRecipeViewModel.deleteAll()
            Toast.makeText(requireContext(), "Successfuly deleted!", Toast.LENGTH_SHORT).show()

        }

        builder.setNegativeButton("No"){_,_ ->}
        builder.setTitle("Delete all?")
        builder.setMessage("Are you sure you want to delete all recipes?")
        builder.create().show()
    }

}