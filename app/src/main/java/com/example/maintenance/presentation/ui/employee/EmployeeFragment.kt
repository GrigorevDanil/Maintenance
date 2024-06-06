package com.example.maintenance.presentation.ui.employee

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maintenance.R
import com.example.maintenance.databinding.FragmentEmployeeBinding
import com.example.maintenance.databinding.FragmentProductBinding
import com.example.maintenance.presentation.entity.Employee
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.ui.ConfirmDialog
import com.example.maintenance.presentation.ui.IActionClickListener
import com.example.maintenance.presentation.ui.IConfirmDialogListener
import com.example.maintenance.presentation.ui.IDialogListener
import com.example.maintenance.presentation.ui.employee.adapterlist.EmployeeAdapter
import com.example.maintenance.presentation.ui.product.ProductDialog
import com.example.maintenance.presentation.ui.product.ProductViewModel
import com.example.maintenance.presentation.ui.product.adapterlist.ProductAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmployeeFragment : Fragment() {

    private val viewModel by viewModel<EmployeeViewModel>()
    private lateinit var employeeAdapter : EmployeeAdapter

    private var _binding: FragmentEmployeeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        employeeAdapter = EmployeeAdapter(requireContext(), object : IActionClickListener<Employee> {

            override fun delete(employee: Employee) {
                ConfirmDialog(
                    requireContext(),
                    object : IConfirmDialogListener {
                        override fun onEnterButtonClicked() {
                            viewModel.deleteEmployee(employee)
                        }
                    }).show()
            }

            override fun update(employee: Employee) {
                EmployeeDialog(
                    requireContext(),
                    object : IDialogListener<Employee> {
                        override fun onAddButtonClicked(item: Employee) {
                            viewModel.updateEmployee(item)
                        }
                    },
                    employee).show()
            }

        } )


        viewModel.getEmployees()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmployeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.employees.observe(viewLifecycleOwner, {
            employeeAdapter.submitUpdate(it)
        })

        binding.rvEmployee.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = employeeAdapter
        }

        binding.butCreate.setOnClickListener()
        {

            EmployeeDialog(
                requireContext(),
                object : IDialogListener<Employee> {
                    override fun onAddButtonClicked(item: Employee) {
                        viewModel.addEmployee(item)
                    }
                }).show()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}