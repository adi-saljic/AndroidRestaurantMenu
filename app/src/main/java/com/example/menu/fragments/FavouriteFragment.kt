package com.example.menu.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import com.example.menu.fragments.FavouriteFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menu.R
import com.example.menu.adapters.FavouriteAdapter
import com.example.menu.adapters.PizzaAdapter
import com.example.menu.viewmodel.PizzaViewModel
import kotlinx.android.synthetic.main.fragment_favourite.view.*


class FavouriteFragment : Fragment() {

    private lateinit var mPizzaViewModel: PizzaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_favourite, container, false)

        val adapter = FavouriteAdapter()

        val recyclerView = view.favourite_recycler

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mPizzaViewModel = ViewModelProvider(this).get(PizzaViewModel::class.java)
        mPizzaViewModel.readAllFavs.observe(viewLifecycleOwner, Observer {pizza ->
            adapter.setData(pizza)
        })

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
            mPizzaViewModel.deleteAllFavs()
            Toast.makeText(requireContext(), "Successfuly deleted!", Toast.LENGTH_SHORT).show()

        }

        builder.setNegativeButton("No"){_,_ ->}
        builder.setTitle("Delete all?")
        builder.setMessage("Are you sure you want to delete all favourites?")
        builder.create().show()
    }


}