package com.example.maintenance.presentation.ui.give.adapterlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.R
import com.example.maintenance.presentation.entity.Employee
import com.example.maintenance.presentation.entity.Give
import com.example.maintenance.presentation.entity.GiveWithEmployee
import com.example.maintenance.presentation.ui.IActionClickListener
import com.example.maintenance.presentation.ui.employee.adapterlist.EmployeeViewHolder
import java.text.SimpleDateFormat

class GiveAdapter(
    private val context: Context,
    private val listener: IActionClickListener<GiveWithEmployee>
) : RecyclerView.Adapter<GiveViewHolder>() {

    private val gives: ArrayList<GiveWithEmployee> = arrayListOf()

    override fun getItemCount(): Int {
        return gives.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GiveViewHolder {
        return GiveViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_give,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GiveViewHolder, position: Int) {
        val give = gives.get(position)

        holder.tvFullName.text = give.employee.Surname + " " + give.employee.Name + (if (give.employee.Lastname!!.isNotEmpty()) give.employee.Lastname else "")
        holder.tvDate.text = SimpleDateFormat("dd.MM.yyyy").format(give.give.DateGive)

        holder.butDelete.setOnClickListener()
        {
            listener.delete(give)
        }

        holder.butEdit.setOnClickListener()
        {
            listener.update(give)
        }
    }

    fun submitUpdate(update: List<GiveWithEmployee>) {
        val callback = GiveDiffCallback(gives, update)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(callback)

        gives.clear()
        gives.addAll(update)
        diffResult.dispatchUpdatesTo(this)
    }

    class GiveDiffCallback(
        private val oldGive: List<GiveWithEmployee>,
        private val newGive: List<GiveWithEmployee>
    ) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldGive.size
        }

        override fun getNewListSize(): Int {
            return newGive.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldGive[oldItemPosition].give.Id == newGive[newItemPosition].give.Id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldGive[oldItemPosition].give.DateGive == newGive[newItemPosition].give.DateGive
        }

    }

}