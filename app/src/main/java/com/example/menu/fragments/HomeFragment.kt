package com.example.menu.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.menu.R
import com.example.menu.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        val view=binding.root
        setHasOptionsMenu(true)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pizzaButton.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_pizzaFragment)
        }
        binding.dessertButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_dessertFragment)
        }

        binding.recipeBtn.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_recipeFragment)
        }

        binding.favouriteBtn.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_favouriteFragment)
        }

        binding.employeeBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_employeeFragment)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu,menu)
    }

}