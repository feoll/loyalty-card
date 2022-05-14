package com.example.loyaltycard.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.loyaltycard.data.dao.BankCardDao
import com.example.loyaltycard.data.db.BankCardDatabase
import com.example.loyaltycard.data.models.BankCard
import com.example.loyaltycard.data.repository.BankCardRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BankCardViewModel(application: Application): AndroidViewModel(application) {

    private val database: BankCardDatabase = BankCardDatabase.getDatabase(context = application)
    private val dao: BankCardDao = database.bankCardDao()
    private val repository: BankCardRepository = BankCardRepository(bankCardDao = dao)

    val getAll: LiveData<List<BankCard>> = repository.getAll

    fun insert(bankCard: BankCard) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(bankCard = bankCard)
        }
    }

    fun update(bankCard: BankCard) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(bankCard = bankCard)
        }
    }

    fun delete(bankCard: BankCard) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(bankCard = bankCard)
        }
    }

    fun search(searchQuery: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.search(searchQuery = searchQuery)
        }
    }
}