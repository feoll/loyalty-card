package com.example.loyaltycard.data.repository

import androidx.lifecycle.LiveData
import com.example.loyaltycard.data.dao.BankCardDao
import com.example.loyaltycard.data.models.BankCard

class BankCardRepository(private val bankCardDao: BankCardDao) {

    val getAll: LiveData<List<BankCard>> = bankCardDao.getAll()

    suspend fun insert(bankCard: BankCard): Long {
        return bankCardDao.insert(bankCard)
    }

    suspend fun update(bankCard: BankCard): Int {
        return bankCardDao.update(bankCard)
    }

    suspend fun delete(bankCard: BankCard): Int {
        return bankCardDao.delete(bankCard)
    }

    fun search(searchQuery: String): LiveData<List<BankCard>> {
        return bankCardDao.search(searchQuery)
    }

}