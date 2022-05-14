package com.example.loyaltycard.fragments.bankCard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.loyaltycard.data.models.BankCard
import com.example.loyaltycard.databinding.RowBankCardBinding

class BankCardRecyclerView : RecyclerView.Adapter<BankCardRecyclerView.CardViewHolder>() {

    private var list: List<BankCard> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(bankCards: List<BankCard>) {
        val bankCardDiffUtil = BankCardDiffUtil(list, bankCards)
        val DiffUtilResult = DiffUtil.calculateDiff(bankCardDiffUtil)
        this.list = bankCards
        DiffUtilResult.dispatchUpdatesTo(this)
    }

    class CardViewHolder(private val binding: RowBankCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(bankCard: BankCard) {
            binding.bankCard = bankCard
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup): CardViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowBankCardBinding.inflate(layoutInflater, parent, false)
                return CardViewHolder(binding)
            }
        }
    }

}