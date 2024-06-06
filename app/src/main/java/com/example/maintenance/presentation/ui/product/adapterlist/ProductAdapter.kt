package com.example.maintenance.presentation.ui.product.adapterlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.R
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.ui.IActionClickListener

class ProductAdapter(
    private val context: Context,
    private val listener: IActionClickListener<Product>
) : RecyclerView.Adapter<ProductViewHolder>() {

    private val products: ArrayList<Product> = arrayListOf()

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_product,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products.get(position)

        holder.tvTitle.text = product.Title
        holder.tvModel.text = product.Model
        holder.tvCountProduct.text = product.CountProduct.toString()
        holder.tvUnit.text = product.Unit.toString()
        holder.tvPrice.text = product.Price.toString()



        holder.butDelete.setOnClickListener()
        {
            listener.delete(product)
        }

        holder.butEdit.setOnClickListener()
        {
            listener.update(product)
        }
    }

    fun submitUpdate(update: List<Product>) {
        val callback = ProductDiffCallback(products, update)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(callback)

        products.clear()
        products.addAll(update)
        diffResult.dispatchUpdatesTo(this)
    }

    class ProductDiffCallback(
        private val oldProduct: List<Product>,
        private val newProduct: List<Product>
    ) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldProduct.size
        }

        override fun getNewListSize(): Int {
            return newProduct.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldProduct[oldItemPosition].Id == newProduct[newItemPosition].Id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldProduct[oldItemPosition].Title == newProduct[newItemPosition].Title && oldProduct[oldItemPosition].Model == newProduct[newItemPosition].Model
        }

    }

}