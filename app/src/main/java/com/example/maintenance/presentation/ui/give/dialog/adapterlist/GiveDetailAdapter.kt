package com.example.maintenance.presentation.ui.give.dialog.adapterlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.R
import com.example.maintenance.presentation.entity.GiveDetailWithProduct
import com.example.maintenance.presentation.entity.GiveWithEmployee
import com.example.maintenance.presentation.ui.IActionClickListener
import com.example.maintenance.presentation.ui.give.adapterlist.GiveViewHolder
import java.text.SimpleDateFormat

class GiveDetailAdapter(
    private val context: Context,
    private val listener: IActionClickListener<GiveDetailWithProduct>
) : RecyclerView.Adapter<GiveDetailViewHolder>() {

    private val giveDetails: ArrayList<GiveDetailWithProduct> = arrayListOf()

    override fun getItemCount(): Int {
        return giveDetails.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GiveDetailViewHolder {
        return GiveDetailViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_give_detail,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GiveDetailViewHolder, position: Int) {
        val giveDetail = giveDetails.get(position)

        holder.tvTitle.text = giveDetail.product.Title
        holder.tvModel.text = giveDetail.product.Model
        holder.tvCountProduct.text = giveDetail.giveDetail.CountProduct.toString()

        holder.butDelete.setOnClickListener()
        {
            listener.delete(giveDetail)
        }

        holder.butEdit.setOnClickListener()
        {
            listener.update(giveDetail)
        }
    }

    fun submitUpdate(update: List<GiveDetailWithProduct>) {
        val callback = GiveDetailDiffCallback(giveDetails, update)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(callback)

        giveDetails.clear()
        giveDetails.addAll(update)
        diffResult.dispatchUpdatesTo(this)
    }

    class GiveDetailDiffCallback(
        private val oldGiveDetail: List<GiveDetailWithProduct>,
        private val newGiveDetail: List<GiveDetailWithProduct>
    ) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldGiveDetail.size
        }

        override fun getNewListSize(): Int {
            return newGiveDetail.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldGiveDetail[oldItemPosition].giveDetail.Id == newGiveDetail[newItemPosition].giveDetail.Id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldGiveDetail[oldItemPosition].giveDetail.CountProduct == newGiveDetail[newItemPosition].giveDetail.CountProduct
        }

    }

}