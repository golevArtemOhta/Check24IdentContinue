package com.example.checkidenttask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.check24tech.domain.model.UriConverter
import com.example.checkidenttask.domain.model.SaleItem

@Database(entities = [SaleItem::class], version = 1, exportSchema = false)
@TypeConverters(UriConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemsDao(): ItemsDao

}




