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
import com.example.menu.models.DessertItem
import com.example.menu.fragments.DessertFragmentDirections

class ItemAdapter(val context:Context, val carsList:List<DessertItem>):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val dessertName:TextView=itemView.findViewById(R.id.dessert_name)
        val dessertQuant:TextView=itemView.findViewById(R.id.dessert_quantity)
        val dessertPrice:TextView=itemView.findViewById(R.id.desert_price)
        val dessertImage:ImageView=itemView.findViewById(R.id.img_desserts)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout=LayoutInflater.from(parent.context).inflate(R.layout.dessert_list_items,parent,false)
        return ViewHolder(adapterLayout)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=carsList[position]
        holder.dessertName.text="Name "+item.name
        holder.dessertPrice.text="Price"+item.price.toString()
        holder.dessertQuant.text="Quantity "+item.quantity.toString()

        Glide.with(context)
            .load(item.img)
            .into(holder.dessertImage)

        holder.itemView.findViewById<CardView>(R.id.dessertRow).setOnClickListener{
            val action= DessertFragmentDirections.actionDessertFragmentToSingleDessertFragment(item)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return carsList.size
    }
}