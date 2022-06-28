package com.example.menu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.menu.R
import com.example.menu.data.EmployeeData

class EmployeeAdapter(
    private val context: Context?
): RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>(){

    val employeeList = EmployeeData.employees

    class EmployeeViewHolder(view: View?):RecyclerView.ViewHolder(view!!){
        val firstName : TextView? = view?.findViewById(R.id.employee_firstName)
        val lastName : TextView? = view?.findViewById(R.id.employee_lastName)
        val job : TextView? = view?.findViewById(R.id.employee_job)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.firstName?.text = employee.firstName
        holder.lastName?.text = employee.lastName
        holder.job?.text = employee.job
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.employee_list_item,parent,false))

    }

}