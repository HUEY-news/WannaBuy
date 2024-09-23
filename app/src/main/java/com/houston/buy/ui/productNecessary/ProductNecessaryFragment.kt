package com.houston.buy.ui.productNecessary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.houston.buy.R
import com.houston.buy.databinding.FragmentProductNecessaryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductNecessaryFragment : Fragment() {
    private var _binding: FragmentProductNecessaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProductNecessaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_necessaryFragment_to_databaseFragment)
        }
    }
}
