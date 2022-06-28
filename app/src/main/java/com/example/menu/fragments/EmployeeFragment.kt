package com.example.menu.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.menu.GridListActivity
import com.example.menu.HorizontalListActivity
import com.example.menu.R
import com.example.menu.VerticalListActivity


class EmployeeFragment : Fragment() {

    lateinit var verticalBtn: Button
    lateinit var horizontalBtn: Button
    lateinit var gridBtn: Button
    private lateinit var listIntent: Intent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_employee, container, false)

        verticalBtn = view.findViewById(R.id.vertical_btn)
        horizontalBtn = view.findViewById(R.id.horizontal_btn)
        gridBtn = view.findViewById(R.id.grid_btn)

        verticalBtn.setOnClickListener {
            launchVertical()
        }

        horizontalBtn.setOnClickListener {
            launchHorizontal()
        }

        gridBtn.setOnClickListener {
            launchGrid()
        }

        return view
    }

    private fun launchGrid() {
        listIntent = Intent(requireContext(), VerticalListActivity::class.java)
        startActivity(listIntent)
    }

    private fun launchHorizontal() {
        listIntent = Intent(requireContext(), HorizontalListActivity::class.java)
        startActivity(listIntent)
    }

    private fun launchVertical() {
        listIntent = Intent(requireContext(), GridListActivity::class.java)
        startActivity(listIntent)
    }


}