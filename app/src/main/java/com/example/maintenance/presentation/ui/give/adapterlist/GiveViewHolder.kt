package com.example.maintenance.presentation.ui.give.adapterlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.R

class GiveViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val tvFullName: TextView = view.findViewById(R.id.tvFullName)
    val tvDate: TextView = view.findViewById(R.id.tvDate)
    val butEdit: ImageView = view.findViewById(R.id.butEdit)
    val butDelete: ImageView = view.findViewById(R.id.butDelete)
}