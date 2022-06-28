package com.example.menu.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.menu.R
import com.example.menu.databinding.FragmentSingleDessertBinding


class SingleDessertFragment : Fragment() {
    private val args by navArgs<SingleDessertFragmentArgs>()
    private var _binding: FragmentSingleDessertBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSingleDessertBinding.inflate(inflater,container,false)
        val view=binding.root
        setHasOptionsMenu(true)

        binding.shareBtn.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT, "CHECK THIS AWESOME DESSERT!! \n" +
                            "Name: ${args.trenutniDessert.name} \n " +
                            "Description: ${args.trenutniDessert.description} \n" +
                            "Price: ${args.trenutniDessert.price}"
                )
                type = "text/plain"

            }
            val sharedIntent = Intent.createChooser(sendIntent, null)
            startActivity(sharedIntent)
        }

        return view
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.dessertsName.text="Name: "+args.trenutniDessert.name
        binding.dessertsDesc.text="Description: "+args.trenutniDessert.description
        binding.dessertsPrice.text="Price: "+args.trenutniDessert.price

        super.onViewCreated(view, savedInstanceState)

    }


}