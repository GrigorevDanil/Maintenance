package com.example.maintenance.presentation.ui

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.maintenance.R
import com.example.maintenance.databinding.DialogConfirmBinding
import com.example.maintenance.databinding.DialogProductBinding
import com.example.maintenance.presentation.entity.Product

class ConfirmDialog (
    context: Context,
    val confirmListener: IConfirmDialogListener
) : AppCompatDialog(context, R.style.RoundedDialog) {

    private var _binding: DialogConfirmBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        _binding = DialogConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.butEnter.setOnClickListener {
            confirmListener.onEnterButtonClicked()
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