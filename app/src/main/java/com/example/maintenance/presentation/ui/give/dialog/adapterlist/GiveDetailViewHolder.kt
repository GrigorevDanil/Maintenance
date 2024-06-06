package com.example.maintenance.presentation.ui.give.dialog.adapterlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.R

class GiveDetailViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    val tvModel: TextView = view.findViewById(R.id.tvDate)
    val tvCountProduct: TextView = view.findViewById(R.id.tvCountProduct)
    val butEdit: ImageView = view.findViewById(R.id.butEdit)
    val butDelete: ImageView = view.findViewById(R.id.butDelete)
}