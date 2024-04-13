package com.example.check24tech.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.check24tech.data.model.SaleItemDto

@Database(entities = [SaleItemDto::class], version = 1, exportSchema = false)
@TypeConverters(UriConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemsDao(): ItemsDao

}




