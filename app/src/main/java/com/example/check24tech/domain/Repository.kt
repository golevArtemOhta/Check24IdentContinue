package com.example.check24tech.domain

import com.example.check24tech.data.model.SaleItemDto
import com.example.check24tech.domain.model.SaleItemModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllSaleItems(): Flow<List<SaleItemModel>>

    fun getSaleItemById(id:Int): Flow<SaleItemModel>

    suspend fun insertSaleItem(saleItemDto: SaleItemDto)

    suspend fun updateSaleItem(saleItemDto: SaleItemDto)
}