package com.example.loyaltycard.fragments.bankCard.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.loyaltycard.data.models.BankCard

class BankCardDiffUtil(private val oldList: List<BankCard>, private val newList: List<BankCard>)
    : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}