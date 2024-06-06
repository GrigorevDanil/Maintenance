package com.example.maintenance.presentation.ui.employee

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.maintenance.R
import com.example.maintenance.databinding.DialogEmployeeBinding
import com.example.maintenance.presentation.entity.Employee
import com.example.maintenance.presentation.ui.IDialogListener

class EmployeeDialog    (
    context: Context,
    var addDialogListener: IDialogListener<Employee>,
    val employee: Employee? = null
) : AppCompatDialog(context, R.style.RoundedDialog) {

    private var _binding: DialogEmployeeBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        _binding = DialogEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etNumPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher());

        if (employee != null)
        {
            binding.etPost.setText(employee.Post)
            binding.etSurname.setText(employee.Surname)
            binding.etName.setText(employee.Name)
            binding.etLastname.setText(employee.Lastname)
            binding.etNumPhone.setText(employee.NumPhone)
            binding.etAddress.setText(employee.Address)
        }

        binding.butEnter.setOnClickListener {
            val post = binding.etPost.text.toString()
            val surname = binding.etSurname.text.toString()
            val name = binding.etName.text.toString()
            val lastname = binding.etLastname.text.toString()
            val numPhone = binding.etNumPhone.text.toString()
            val address = binding.etAddress.text.toString()

            if(post.isNullOrEmpty() || surname.isNullOrEmpty() || name.isNullOrEmpty() || numPhone.isNullOrEmpty() || address.isNullOrEmpty()) {
                Toast.makeText(context, "Не все поля были введены", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(!numPhone.matches("(\\+7|8)\\s(\\d{3})\\s(\\d{3})-(\\d{2})-(\\d{2})".toRegex())) {
                Toast.makeText(context, "Некорректный номер телефона", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = Employee(employee?.Id ?: 0,post, surname,name, lastname,numPhone, address)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.butCancel.setOnClickListener {
            cancel()
        }
    }

    override fun setOnDismissListener(listener: DialogInterface.OnDismissListener?) {
        super.setOnDismissListener(listener)
        _binding = null
    }

}