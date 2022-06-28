package com.example.menu.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.Gravity.apply
import androidx.core.view.GravityCompat.apply
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menu.R
import com.example.menu.adapters.ItemAdapter
import com.example.menu.databinding.FragmentDessertBinding
import com.example.menu.interfaces.ApiInterface
import com.example.menu.models.DessertItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DessertFragment : Fragment() {
    val BASE_URL = "https://pizza-and-desserts.p.rapidapi.com/"
    lateinit var MyAdapter: ItemAdapter
    private lateinit var recycler: RecyclerView
    private var _binding: FragmentDessertBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDessertBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = binding.dessertrecycler
        recycler.layoutManager = LinearLayoutManager(requireContext())

        getMyData();
        super.onViewCreated(view, savedInstanceState)
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<DessertItem>?> {
            override fun onResponse(
                call: Call<List<DessertItem>?>,
                response: Response<List<DessertItem>?>
            ) {
                val responseBody = response.body()!!
                MyAdapter = ItemAdapter(requireContext(), responseBody)
                MyAdapter.notifyDataSetChanged()
                recycler.adapter = MyAdapter

            }

            override fun onFailure(call: Call<List<DessertItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }





}