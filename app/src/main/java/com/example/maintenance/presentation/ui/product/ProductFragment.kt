package com.example.maintenance.presentation.ui.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maintenance.databinding.FragmentProductBinding
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.ui.ConfirmDialog
import com.example.maintenance.presentation.ui.IActionClickListener
import com.example.maintenance.presentation.ui.IConfirmDialogListener
import com.example.maintenance.presentation.ui.IDialogListener
import com.example.maintenance.presentation.ui.product.adapterlist.ProductAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductFragment : Fragment() {

    private val viewModel by viewModel<ProductViewModel>()
    private lateinit var productAdapter : ProductAdapter

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        productAdapter = ProductAdapter(requireContext(), object : IActionClickListener<Product> {

            override fun delete(product: Product) {
                ConfirmDialog(
                    requireContext(),
                    object : IConfirmDialogListener {
                        override fun onEnterButtonClicked() {
                            viewModel.deleteProduct(product)
                        }
                    }).show()
            }

            override fun update(product: Product) {
                ProductDialog(
                    requireContext(),
                    object : IDialogListener<Product> {
                        override fun onAddButtonClicked(item: Product) {
                            viewModel.updateProduct(item)
                        }
                    },
                    product).show()
            }

        } )


        viewModel.getProducts()

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.products.observe(viewLifecycleOwner, {
            productAdapter.submitUpdate(it)
        })

        binding.rvProduct.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }

        binding.butCreate.setOnClickListener()
        {
            ProductDialog(
                requireContext(),
                object : IDialogListener<Product> {
                    override fun onAddButtonClicked(item: Product) {
                        viewModel.addProduct(item)
                    }
                }).show()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }





}