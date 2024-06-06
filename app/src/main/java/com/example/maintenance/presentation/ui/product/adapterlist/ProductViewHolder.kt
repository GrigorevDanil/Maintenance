package com.example.maintenance.presentation.ui.product.adapterlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.R

class ProductViewHolder(view : View): RecyclerView.ViewHolder(view) {
    val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    val tvModel: TextView = view.findViewById(R.id.tvModel)
    val tvCountProduct: TextView = view.findViewById(R.id.tvCountProduct)
    val tvUnit: TextView = view.findViewById(R.id.tvUnit)
    val tvPrice: TextView = view.findViewById(R.id.tvPrice)
    val butEdit: ImageView = view.findViewById(R.id.butEdit)
    val butDelete: ImageView = view.findViewById(R.id.butDelete)
}