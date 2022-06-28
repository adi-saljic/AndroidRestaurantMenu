package com.example.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.menu.adapters.EmployeeAdapter
import com.example.menu.databinding.ActivityHorizontalListBinding


class HorizontalListActivity: AppCompatActivity() {

    private lateinit var binding : ActivityHorizontalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHorizontalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.horizontalRecyclerView.adapter = EmployeeAdapter(applicationContext)

        binding.horizontalRecyclerView.setHasFixedSize(true)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

}