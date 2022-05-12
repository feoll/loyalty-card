package com.example.loyaltycard.fragments.discountCard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.loyaltycard.R
import com.example.loyaltycard.databinding.FragmentDiscountCardBinding


class DiscountCardFragment : Fragment() {

    private var _binding: FragmentDiscountCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDiscountCardBinding.inflate(inflater, container, false)

        binding.addDiscountFAB.setOnClickListener {
            val direction = DiscountCardFragmentDirections.actionDiscountCardFragmentToAddDiscountCardFragment()
            findNavController().navigate(direction)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}