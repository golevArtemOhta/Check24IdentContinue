package com.example.check24tech.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.check24tech.data.model.SaleItemDto
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDao {

    @Query("SELECT * FROM items_table")
    fun getAllItems(): Flow<List<SaleItemDto>>

    @Query("SELECT * FROM items_table WHERE id = :id")
    fun getItemById(id: Int): Flow<SaleItemDto>

    @Insert()
    suspend fun insertSaleItem(saleItemDto: SaleItemDto)

    @Update
    suspend fun updateSaleItem(saleItemDto: SaleItemDto)

}