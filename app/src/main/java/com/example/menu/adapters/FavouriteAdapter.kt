package com.example.menu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.menu.R

import com.example.menu.models.PizzaBase


import kotlinx.android.synthetic.main.pizza_row.view.*

class FavouriteAdapter: RecyclerView.Adapter<FavouriteAdapter.MyViewHolder>() {

    private var pizzaList = emptyList<PizzaBase>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pizza_row,parent,false))
    }

    override fun onBindViewHolder(holder: FavouriteAdapter.MyViewHolder, position: Int) {
        val currentItem = pizzaList[position]

        holder.itemView.name_pizza_txt.text = currentItem.name
        holder.itemView.desc_pizza_txt.text = currentItem.description
        holder.itemView.price_pizza_txt.text = currentItem.price.toString()


    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }

    fun setData(pizza : List<PizzaBase>){
        this.pizzaList = pizza
        notifyDataSetChanged()
    }
}