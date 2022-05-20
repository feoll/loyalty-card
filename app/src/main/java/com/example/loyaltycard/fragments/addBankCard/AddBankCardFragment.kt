package com.example.loyaltycard.fragments.addBankCard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.loyaltycard.R
import com.example.loyaltycard.data.models.BankCard
import com.example.loyaltycard.data.viewmodel.BankCardViewModel
import com.example.loyaltycard.databinding.FragmentAddBankCardBinding

class AddBankCardFragment : Fragment() {

    private var _binding: FragmentAddBankCardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BankCardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBankCardBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_bank_card_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.save -> {saveData()}
        }
        return super.onOptionsItemSelected(item)
    }

    fun saveData() {
        val cardName: String = binding.cardName.editText!!.text.toString().trim()
        val bankName: String = binding.bankName.editText!!.text.toString().trim()
        val numberStr: String = binding.cardNumber.editText!!.text.toString().trim()
        val number = StringBuffer(numberStr).insert(12, "   ").insert(8, "   ").insert(4, "   ").toString().trim()
        val dateStr: String = binding.cardDate.editText!!.text.toString().trim()
        val date = StringBuffer(dateStr).insert(2, "/").toString()
        val pin: Int = binding.cardPin.editText!!.text.toString().trim().toInt()
        val cvv: Int = binding.cardCVV.editText!!.text.toString().trim().toInt()
        val cardHolder: String = binding.cardHolder.editText!!.text.toString().trim()

        val bankCard = BankCard(id = 0, cardName = cardName, bankName = bankName, number = number, date = date, pin = pin, cvv = cvv, cardHolder = cardHolder)

        if(cardName.isNotEmpty()) {
            viewModel.insert(bankCard)
            val direction = AddBankCardFragmentDirections.actionAddBankCardFragmentToBankCardFragment()
            findNavController().navigate(direction)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}