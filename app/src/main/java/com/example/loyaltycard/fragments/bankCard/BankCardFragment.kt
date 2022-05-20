package com.example.loyaltycard.fragments.bankCard

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loyaltycard.R
import com.example.loyaltycard.data.viewmodel.BankCardViewModel
import com.example.loyaltycard.databinding.FragmentBankCardBinding
import com.example.loyaltycard.fragments.bankCard.adapter.BankCardRecyclerView


class BankCardFragment : Fragment() {

    private var _binding: FragmentBankCardBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { BankCardRecyclerView() }
    private val viewModel: BankCardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBankCardBinding.inflate(inflater, container, false)

        binding.addDiscountFAB.setOnClickListener {
            val direction = BankCardFragmentDirections.actionBankCardFragmentToAddBankCardFragment()
            findNavController().navigate(direction)
        }


        binding.bankCardRecyclerView.adapter = adapter
        binding.bankCardRecyclerView.setHasFixedSize(true)
        binding.bankCardRecyclerView.setItemViewCacheSize(20)
        binding.bankCardRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.lifecycleOwner = this

        viewModel.getAll.observe(viewLifecycleOwner, Observer {
            adapter.setData(bankCards = it)
        })

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