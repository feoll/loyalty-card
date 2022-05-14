package com.example.loyaltycard.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.loyaltycard.data.dao.BankCardDao
import com.example.loyaltycard.data.models.BankCard

@Database(entities = [BankCard::class], version = 1, exportSchema = false)
abstract class BankCardDatabase: RoomDatabase() {

    abstract fun bankCardDao(): BankCardDao

    companion object {
        @Volatile
        private var INSTANCE: BankCardDatabase? = null

        fun getDatabase(context: Context): BankCardDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val database = Room.databaseBuilder(
                    context.applicationContext,
                    BankCardDatabase::class.java,
                    "bank_card_database"
                ).build()
                INSTANCE = database
                return database
            }
        }
    }
}