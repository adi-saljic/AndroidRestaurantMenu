package com.example.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.menu.R
import com.example.menu.fragments.RecipeFragmentDirections
import com.example.menu.models.Recipe
import kotlinx.android.synthetic.main.fragment_add_recipe.view.*
import kotlinx.android.synthetic.main.recipe_row.view.*

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.MyViewHolder>() {

    private var recipeList = emptyList<Recipe>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recipe_row,parent,false))
    }

    override fun onBindViewHolder(holder: RecipeAdapter.MyViewHolder, position: Int) {
        val currentItem = recipeList[position]
        holder.itemView.name_recipe_txt.text = currentItem.name
        holder.itemView.category_recipe_txt.text = currentItem.category
        holder.itemView.ing_recipe_txt.text = currentItem.ingredients
        holder.itemView.desc_recipe_txt.text = currentItem.desc

        holder.itemView.findViewById<CardView>(R.id.recipe_row).setOnClickListener{
            val action = RecipeFragmentDirections.actionRecipeFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    fun setData(recipe : List<Recipe>){
        this.recipeList = recipe
        notifyDataSetChanged()
    }


}