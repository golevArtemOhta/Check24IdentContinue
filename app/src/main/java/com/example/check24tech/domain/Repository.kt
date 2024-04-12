package com.example.check24tech.domain

import com.example.check24tech.domain.model.SaleItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface Repository {

    fun getAllSaleItems(): Flow<List<SaleItem>>

    fun getSaleItemById(id:Int): Flow<SaleItem>

    suspend fun insertSaleItem(saleItem: SaleItem)

    suspend fun updateSaleItem(saleItem: SaleItem)
}