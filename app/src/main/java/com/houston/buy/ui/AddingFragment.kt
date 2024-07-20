package com.houston.buy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.FirebaseDatabase
import com.houston.buy.databinding.FragmentAddingBinding
import com.houston.buy.domain.model.Product

class AddingFragment : Fragment() {
    private var _binding: FragmentAddingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSave.setOnClickListener {

            val name = binding.productName.text.toString()
            val description = binding.productDescription.text.toString()

            val product = Product(
                id = null,
                name = name,
                description = description
            )

            if (name.isNotEmpty()) {
                binding.productName.text.clear()
                binding.productDescription.text.clear()
            } else Toast.makeText(requireContext(), "Имя продукта не может быть пустым!", Toast.LENGTH_SHORT).show()
        }
    }
}
