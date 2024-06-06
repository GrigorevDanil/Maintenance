package com.example.maintenance.presentation.ui.give.dialog

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maintenance.R
import com.example.maintenance.databinding.ActivityGiveDialogBinding
import com.example.maintenance.databinding.FragmentGiveBinding
import com.example.maintenance.presentation.entity.Employee
import com.example.maintenance.presentation.entity.GiveDetail
import com.example.maintenance.presentation.entity.GiveDetailWithProduct
import com.example.maintenance.presentation.entity.GiveWithEmployee
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.ui.ConfirmDialog
import com.example.maintenance.presentation.ui.IActionClickListener
import com.example.maintenance.presentation.ui.IConfirmDialogListener
import com.example.maintenance.presentation.ui.IDialogListener
import com.example.maintenance.presentation.ui.give.GiveViewModel
import com.example.maintenance.presentation.ui.give.adapterlist.GiveAdapter
import com.example.maintenance.presentation.ui.give.dialog.adapterlist.GiveDetailAdapter
import com.example.maintenance.presentation.ui.product.ProductDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class GiveDialog : AppCompatActivity() {

    private val viewModel by viewModel<GiveDialogViewModel>()

    private lateinit var giveDetailAdapter : GiveDetailAdapter
    private lateinit var employeeAdapter : ArrayAdapter<Employee>

    private var _binding: ActivityGiveDialogBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityGiveDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Получениe выдачи
        val give: GiveWithEmployee? = intent.getParcelableExtra("give")

        //Список детальных выдач
        giveDetailAdapter = GiveDetailAdapter(applicationContext, object :
            IActionClickListener<GiveDetailWithProduct> {

            override fun delete(giveDetail: GiveDetailWithProduct) {
                ConfirmDialog(
                    applicationContext,
                    object : IConfirmDialogListener {
                        override fun onEnterButtonClicked() {
                            viewModel.deleteGive(giveDetail)
                        }
                    }).show()
            }

            override fun update(giveDetail: GiveDetailWithProduct) {
                GiveDetailDialog(
                    applicationContext,
                    object : IDialogListener<GiveDetailWithProduct> {
                        override fun onAddButtonClicked(item: GiveDetailWithProduct) {
                            viewModel.updateGive(item)
                        }
                    },
                    viewModel.products.value!!,
                    give!!,
                    giveDetail).show()
            }

        } )

        viewModel.getGiveDetails()

        viewModel.giveDetails.observe(this, {
            giveDetailAdapter.submitUpdate(it)
        })

        binding.rvGiveDetail.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = giveDetailAdapter
        }

        binding.butCreate.setOnClickListener()
        {
            GiveDetailDialog(
                applicationContext,
                object : IDialogListener<GiveDetailWithProduct> {
                    override fun onAddButtonClicked(item: GiveDetailWithProduct) {
                        viewModel.addGive(item)
                    }
                },
                viewModel.products.value!!,
                give!!).show()
        }

        //Список сотрудников
        val employeeAdapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            viewModel.employees.value!!.map { it.Id }
        )
        employeeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.sEmployee.adapter = employeeAdapter

        //Подтверждение

        binding.butEnter.setOnClickListener({
            val resultGive = GiveWithEmployee(if (give != null) give.give else null,give!!.employee)
            val intent = Intent()
            intent.putExtra("resultGive", resultGive)
            setResult(Activity.RESULT_OK, intent)
            finish()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}