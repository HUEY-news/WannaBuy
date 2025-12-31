package com.houston.buy.ui.productCreation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.houston.buy.databinding.FragmentProductCreationBinding
import com.houston.buy.presentation.ProductCreationViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.FileOutputStream

@AndroidEntryPoint
class ProductCreationFragment : Fragment() {
    private var _binding: FragmentProductCreationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductCreationViewModel by viewModels()

    private var productImageUri: Uri? = null
    private var productName: String = ""
    private var productDescription: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProductCreationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtonListeners()
        setupInputListeners()
    }

    private fun setupInputListeners() {
        binding.productNameInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(input: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(input: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(input: Editable?) {
                productName = input.toString()
                binding.buttonCreate.isEnabled = productName.isNotEmpty()
            }
        })

        binding.productDescriptionInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(input: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(input: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(input: Editable?) {
                productDescription = input.toString()
            }
        })
    }

    private fun setupButtonListeners() {
        binding.buttonBack.setOnClickListener { findNavController().navigateUp() }

        val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                productImageUri = uri
                binding.productImage.setImageURI(uri)
                binding.productImage.scaleType = ImageView.ScaleType.CENTER_CROP
            }
        }

        binding.productImage.setOnClickListener {
            pickMedia.launch(
                PickVisualMediaRequest(
                    ActivityResultContracts.PickVisualMedia.ImageOnly
                )
            )
        }

        binding.buttonCreate.setOnClickListener {
            productImageUri?.let { saveImageToPrivateStorage(it) }
            viewModel.createNewProduct(productName, productDescription, productImageUri)
            Toast.makeText(requireContext(), "Продукт [ $productName ] создан", Toast.LENGTH_SHORT).show()
            findNavController().navigateUp()
        }
    }

    private fun saveImageToPrivateStorage(uri: Uri) {
        val filePath = File(requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "WannaBuy")
        if (!filePath.exists()) filePath.mkdirs()
        val file = File(filePath, productName)
        val inputStream = requireActivity().contentResolver.openInputStream(uri)
        val outputStream = FileOutputStream(file)

        BitmapFactory
            .decodeStream(inputStream)
            .compress(Bitmap.CompressFormat.JPEG, 30, outputStream)
    }
}
