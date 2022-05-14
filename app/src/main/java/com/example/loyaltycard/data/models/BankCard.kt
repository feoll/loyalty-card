package com.example.loyaltycard.data.models


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank_card_table")
data class BankCard(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var cardName: String,
    var bankName: String,
    var number: String,
    var date: String,
    var pin: Int,
    var cvv: Int,
    var cardHolder: String
)
