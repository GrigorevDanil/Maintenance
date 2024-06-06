package com.example.maintenance.presentation.ui.give.dialog


import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.maintenance.R
import com.example.maintenance.databinding.DialogGiveDetailBinding
import com.example.maintenance.presentation.entity.GiveDetailWithProduct
import com.example.maintenance.presentation.entity.GiveWithEmployee
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.ui.IDialogListener


class GiveDetailDialog
    (
    context: Context,
    var addDialogListener: IDialogListener<GiveDetailWithProduct>,
    val productList : List<Product>,
    val give: GiveWithEmployee,
    val giveDetail: GiveDetailWithProduct? = null
) : AppCompatDialog(context, R.style.RoundedDialog) {

    private var _binding: DialogGiveDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        _binding = DialogGiveDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter<String>(
            context,
            android.R.layout.simple_spinner_item,
            productList.map { it.Title + " " + it.Model }
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.sProduct.adapter = adapter


        if (giveDetail != null)
        {
            binding.sProduct.setSelection(adapter.getPosition(giveDetail.product.Title + " " + giveDetail.product.Model))
            binding.etCountProduct.setText(giveDetail.giveDetail.CountProduct.toString())
        }

        binding.butEnter.setOnClickListener {
            var product = productList.get(binding.sProduct.selectedItemPosition)
            val item = GiveDetailWithProduct(giveDetail!!.giveDetail ,product)
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