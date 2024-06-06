package com.example.maintenance.presentation.ui.employee.adapterlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.maintenance.R
import com.example.maintenance.presentation.entity.Employee
import com.example.maintenance.presentation.ui.IActionClickListener

class EmployeeAdapter(
    private val context: Context,
    private val listener: IActionClickListener<Employee>
) : RecyclerView.Adapter<EmployeeViewHolder>() {

    private val employees: ArrayList<Employee> = arrayListOf()

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): EmployeeViewHolder {
        return EmployeeViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_employee,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employees.get(position)

        holder.tvFullName.text = employee.Surname + " " + employee.Name + (if (employee.Surname.isNotEmpty()) " " + employee.Surname else "")
        holder.tvPost.text = employee.Post
        holder.tvNumPhone.text = employee.NumPhone
        holder.tvAddress.text = employee.Address

        holder.butDelete.setOnClickListener()
        {
            listener.delete(employee)
        }

        holder.butEdit.setOnClickListener()
        {
            listener.update(employee)
        }
    }

    fun submitUpdate(update: List<Employee>) {
        val callback = EmployeeDiffCallback(employees, update)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(callback)

        employees.clear()
        employees.addAll(update)
        diffResult.dispatchUpdatesTo(this)
    }

    class EmployeeDiffCallback(
        private val oldEmployee: List<Employee>,
        private val newEmployee: List<Employee>
    ) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldEmployee.size
        }

        override fun getNewListSize(): Int {
            return newEmployee.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldEmployee[oldItemPosition].Id == newEmployee[newItemPosition].Id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldEmployee[oldItemPosition].Surname == newEmployee[newItemPosition].Surname &&
                    oldEmployee[oldItemPosition].Name == newEmployee[newItemPosition].Name &&
                    oldEmployee[oldItemPosition].NumPhone == newEmployee[newItemPosition].NumPhone
        }

    }

}