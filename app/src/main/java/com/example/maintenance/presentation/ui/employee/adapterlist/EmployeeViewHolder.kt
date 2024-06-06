package com.example.maintenance.presentation.ui.employee.adapterlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.R

class EmployeeViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val tvFullName: TextView = view.findViewById(R.id.tvFullName)
    val tvPost: TextView = view.findViewById(R.id.tvPost)
    val tvNumPhone: TextView = view.findViewById(R.id.tvNumPhone)
    val tvAddress: TextView = view.findViewById(R.id.tvAddress)
    val butEdit: ImageView = view.findViewById(R.id.butEdit)
    val butDelete: ImageView = view.findViewById(R.id.butDelete)
}