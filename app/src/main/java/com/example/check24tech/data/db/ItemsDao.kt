package com.example.check24tech.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.check24tech.domain.model.SaleItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface ItemsDao {

    @Query("SELECT * FROM items_table")
    fun getAllItems(): Flow<List<SaleItem>>

    @Query("SELECT * FROM items_table WHERE id = :id")
    fun getItemById(id: Int): Flow<SaleItem>

    @Insert()
    suspend fun insertSaleItem(saleItem: SaleItem)

    @Update
    suspend fun updateSaleItem(saleItem: SaleItem)

}