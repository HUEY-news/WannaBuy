package com.houston.buy.ui.productDatabase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.houston.buy.R
import com.houston.buy.databinding.FragmentProductDatabaseBinding
import com.houston.buy.domain.model.Product
import com.houston.buy.domain.model.ProductDatabaseScreenState
import com.houston.buy.presentation.ProductDatabaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDatabaseFragment : Fragment() {
    private var _binding: FragmentProductDatabaseBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductDatabaseViewModel by viewModels()

    private var adapter: ProductDatabaseAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProductDatabaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupButtonListeners()

        viewModel.observeScreenState().observe(viewLifecycleOwner) { screenState ->
            when (screenState) {
                is ProductDatabaseScreenState.Content -> showContent(screenState.data)
                is ProductDatabaseScreenState.Empty -> showEmpty()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    private fun setupRecyclerView() {
        adapter = ProductDatabaseAdapter {}
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        val swipeCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: ViewHolder, target: ViewHolder): Boolean = false

            override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                val position = viewHolder.bindingAdapterPosition

                if (direction == ItemTouchHelper.RIGHT) {
                    val product = adapter?.removeItem(position)
                    product?.let { viewModel.removeProduct(product.id) }
                }
            }
        }

        val swipeHelper = ItemTouchHelper(swipeCallback)
        swipeHelper.attachToRecyclerView(binding.recycler)
    }

    private fun setupButtonListeners() {
        binding.buttonBack.setOnClickListener { findNavController().navigateUp() }
        binding.buttonAdd.setOnClickListener { findNavController().navigate(R.id.action_databaseFragment_to_addingFragment) }
    }

    private fun showContent(data: List<Product>) {
        showEmptyPlaceholder(false)
        updateProductList(data)
        showProductList(true)
    }

    private fun showEmpty() {
        showEmptyPlaceholder(true)
        updateProductList(listOf())
        showProductList(false)
    }

    private fun updateProductList(list: List<Product>) { adapter?.submitList(list) }
    private fun showProductList(isVisible: Boolean) { binding.recycler.isVisible = isVisible }
    private fun showEmptyPlaceholder(isVisible: Boolean) { binding.placeholder.isVisible = isVisible }
}
