package com.example.loyaltycard.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.loyaltycard.data.models.BankCard

@Dao
interface BankCardDao {

    @Query("SELECT * FROM bank_card_table ORDER BY id ASC")
    fun getAll(): LiveData<List<BankCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(bankCard: BankCard): Long

    @Update
    suspend fun update(bankCard: BankCard): Int

    @Delete
    suspend fun delete(bankCard: BankCard): Int

    @Query("SELECT * FROM bank_card_table WHERE cardName LIKE :searchQuery")
    fun search(searchQuery: String): LiveData<List<BankCard>>
}