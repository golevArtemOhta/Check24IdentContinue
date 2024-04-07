package com.example.checkidenttask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.checkidenttask.domain.model.SaleItem

@Database(entities = [SaleItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemsDao(): ItemsDao

}




