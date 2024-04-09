package com.example.check24tech.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.check24tech.domain.model.SaleItem

@Dao
interface ItemsDao {

    @Query("SELECT * FROM items_table")
    fun getAllItems(): List<SaleItem>

    @Query("SELECT * FROM items_table WHERE id = :id")
    fun getItemById(id: Int): SaleItem

    @Insert()
    suspend fun insertSaleItem(saleItem: SaleItem)

    @Update
    suspend fun updateSaleItem(saleItem: SaleItem)

}