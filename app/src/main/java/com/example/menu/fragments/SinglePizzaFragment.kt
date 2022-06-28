package com.example.menu.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.room.PrimaryKey
import com.example.menu.R
import com.example.menu.databinding.FragmentSinglePizzaBinding
import com.example.menu.models.PizzaBase
import com.example.menu.models.Sizeandcrust
import com.example.menu.viewmodel.PizzaViewModel


class SinglePizzaFragment : Fragment() {
    private val args by navArgs<SinglePizzaFragmentArgs>()
    private var _binding: FragmentSinglePizzaBinding?=null
    private val binding get()=_binding!!

    private lateinit var mPizzaViewMode: PizzaViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentSinglePizzaBinding.inflate(inflater,container,false)
        val view=binding.root

        mPizzaViewMode = ViewModelProvider(this).get(PizzaViewModel::class.java)

        setHasOptionsMenu(true)

        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.pizzasName.text="Name: "+args.trenutnaPizza.name
        binding.pizzasDesc.text="Description: "+args.trenutnaPizza.description
        binding.pizzasPrice.text="Price: "+args.trenutnaPizza.price


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fav_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_favourite){
            addFav()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addFav() {
        var description: String = args.trenutnaPizza.description
        var name: String = args.trenutnaPizza.name
        var price: Int = args.trenutnaPizza.price
        val pizza = PizzaBase(0,description, name, price)
        mPizzaViewMode.addPizza(pizza)
    }


}