package com.houston.buy.ui.productInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.houston.buy.databinding.FragmentProductInfoBinding
import com.houston.buy.presentation.ProductInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductInfoFragment : Fragment() {
    private var _binding: FragmentProductInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductInfoViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProductInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
}
