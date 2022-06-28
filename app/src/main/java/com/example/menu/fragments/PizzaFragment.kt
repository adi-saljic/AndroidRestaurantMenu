package com.example.menu.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menu.R
import com.example.menu.adapters.PizzaAdapter
import com.example.menu.databinding.FragmentPizza2Binding
import com.example.menu.interfaces.ApiInterface
import com.example.menu.models.PizzaItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PizzaFragment : Fragment() {
    val BASE_URL="https://pizza-and-desserts.p.rapidapi.com/"
    lateinit var MyAdapter: PizzaAdapter
    private lateinit var recycler: RecyclerView



    private var _binding:FragmentPizza2Binding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentPizza2Binding.inflate(inflater,container,false)
        val view=binding.root
        setHasOptionsMenu(true)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler=binding.pizzarecycler
        recycler.layoutManager=LinearLayoutManager(requireContext())

        getMyData();


        super.onViewCreated(view, savedInstanceState)
    }
    private fun getMyData() {
        val retrofitBuilder= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData=retrofitBuilder.getPizzaData()
        retrofitData.enqueue(object : Callback<List<PizzaItem>?> {
            override fun onResponse(
                call: Call<List<PizzaItem>?>,
                response: Response<List<PizzaItem>?>
            ) {
                val responseBody=response.body()!!
                MyAdapter= PizzaAdapter(requireContext(), responseBody)
                MyAdapter.notifyDataSetChanged()
                recycler.adapter=MyAdapter

            }

            override fun onFailure(call: Call<List<PizzaItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu,menu)
    }

}



