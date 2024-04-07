package com.example.checkidenttask.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.checkidenttask.domain.model.SaleItem

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