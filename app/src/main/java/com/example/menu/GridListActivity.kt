package com.example.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.menu.adapters.EmployeeAdapter
import com.example.menu.databinding.ActivityGridListBinding

class GridListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityGridListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gridRecyclerView.adapter = EmployeeAdapter(applicationContext)
        // Specify fixed size to improve performance
        binding.gridRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}