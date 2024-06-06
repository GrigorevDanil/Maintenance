package com.example.maintenance.presentation.ui.product

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.maintenance.R
import com.example.maintenance.databinding.DialogProductBinding
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.ui.IDialogListener


class ProductDialog
    (
    context: Context,
    var addDialogListener: IDialogListener<Product>,
    val product: Product? = null
    ) : AppCompatDialog(context, R.style.RoundedDialog) {

    private var _binding: DialogProductBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        _binding = DialogProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (product != null)
        {
            binding.etTitle.setText(product.Title)
            binding.etModel.setText(product.Model)
            binding.etCountProduct.setText(product.CountProduct.toString())
            binding.etUnit.setText(product.Unit)
            binding.etPrice.setText(product.Price.toString())
        }

        binding.butEnter.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val model = binding.etModel.text.toString()
            val countProduct = binding.etCountProduct.text.toString().toIntOrNull()
            val unit = binding.etUnit.text.toString()
            val price = binding.etPrice.text.toString().toIntOrNull()

            if(title.isNullOrEmpty() || model.isNullOrEmpty() || countProduct == null || unit.isNullOrEmpty() || price == null) {
                Toast.makeText(context, "Не все поля были введены", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = Product(product?.Id ?: 0,title,model, countProduct,unit, price)
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