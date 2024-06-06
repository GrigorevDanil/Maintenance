package com.example.maintenance.presentation.ui.give

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maintenance.R
import com.example.maintenance.databinding.FragmentGiveBinding
import com.example.maintenance.databinding.FragmentProductBinding
import com.example.maintenance.presentation.entity.GiveWithEmployee
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.ui.ConfirmDialog
import com.example.maintenance.presentation.ui.IActionClickListener
import com.example.maintenance.presentation.ui.IConfirmDialogListener
import com.example.maintenance.presentation.ui.IDialogListener
import com.example.maintenance.presentation.ui.give.adapterlist.GiveAdapter
import com.example.maintenance.presentation.ui.give.dialog.GiveDialog
import com.example.maintenance.presentation.ui.give.dialog.GiveDialogContract
import com.example.maintenance.presentation.ui.product.ProductDialog
import com.example.maintenance.presentation.ui.product.ProductViewModel
import com.example.maintenance.presentation.ui.product.adapterlist.ProductAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class GiveFragment : Fragment() {

    private val viewModel by viewModel<GiveViewModel>()
    private lateinit var giveAdapter : GiveAdapter

    private var _binding: FragmentGiveBinding? = null
    private val binding get() = _binding!!

    private val giveDialogAdd = registerForActivityResult(GiveDialogContract()) { result ->
        result?.let {



            viewModel.addGive(it)
        }
    }

    private val giveDialogUpdate = registerForActivityResult(GiveDialogContract()) { result ->
        result?.let {
            viewModel.updateGive(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        giveAdapter = GiveAdapter(requireContext(), object : IActionClickListener<GiveWithEmployee> {

            override fun delete(give: GiveWithEmployee) {
                ConfirmDialog(
                    requireContext(),
                    object : IConfirmDialogListener {
                        override fun onEnterButtonClicked() {
                            viewModel.deleteGive(give)
                        }
                    }).show()
            }

            override fun update(give: GiveWithEmployee) {
                giveDialogUpdate.launch(give)
            }

        } )


        viewModel.getGives()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.gives.observe(viewLifecycleOwner, {
            giveAdapter.submitUpdate(it)
        })

        binding.rvGive.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = giveAdapter
        }

        binding.butCreate.setOnClickListener()
        {
            giveDialogAdd.launch(null)
        }
    }

}