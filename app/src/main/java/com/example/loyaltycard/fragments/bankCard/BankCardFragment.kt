package com.example.loyaltycard.fragments.bankCard

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.loyaltycard.R
import com.example.loyaltycard.databinding.FragmentBankCardBinding


class BankCardFragment : Fragment() {

    private var _binding: FragmentBankCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBankCardBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bank_fragment_menu, menu)

        val searchView: SearchView = menu.findItem(R.id.app_bar_search).actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}