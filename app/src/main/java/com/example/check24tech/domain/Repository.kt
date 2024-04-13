package com.example.check24tech.domain

import com.example.check24tech.domain.model.SaleItemModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllSaleItems(): Flow<List<SaleItemModel>>

    fun getSaleItemById(id: Int): Flow<SaleItemModel>

    suspend fun insertSaleItem(saleItemModel: SaleItemModel)

    suspend fun updateSaleItem(saleItemModel: SaleItemModel)
}