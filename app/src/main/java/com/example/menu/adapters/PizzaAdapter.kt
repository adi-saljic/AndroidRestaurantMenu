package com.example.menu.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.menu.R
import com.example.menu.fragments.PizzaFragmentDirections
import com.example.menu.models.PizzaBase
import com.example.menu.models.PizzaItem
import com.example.menu.models.SendPizza

class PizzaAdapter(val context:Context, val pizzaList:List<PizzaItem>):RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val pizzaName:TextView=itemView.findViewById(R.id.pizza_name)
        val pizzaPrice:TextView=itemView.findViewById(R.id.pizza_price)
        val pizzaImage:ImageView=itemView.findViewById(R.id.img_pizzas)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout=
            LayoutInflater.from(parent.context).inflate(R.layout.pizza_list_items,parent,false)
        return PizzaAdapter.ViewHolder(adapterLayout)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=pizzaList[position]
        holder.pizzaName.text="Name: "+item.name
        holder.pizzaPrice.text="Price "+item.price.toString()

        Glide.with(context)
            .load(item.img)
            .into(holder.pizzaImage)

        holder.itemView.findViewById<CardView>(R.id.pizzaRow).setOnClickListener{
            val novaPizza=SendPizza(item.description,item.name,item.price)
            val action=PizzaFragmentDirections.actionPizzaFragmentToSinglePizzaFragment(novaPizza)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }
}