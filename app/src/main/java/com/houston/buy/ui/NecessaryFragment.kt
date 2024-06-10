package com.houston.buy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.houston.buy.databinding.FragmentNecessaryBinding

class NecessaryFragment : Fragment() {
    private var _binding: FragmentNecessaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNecessaryBinding.inflate(inflater, container, false)
        return binding.root
    }
}
