package com.example.check24tech.domain

import com.example.check24tech.domain.model.SaleItem

interface Repository {

    fun getAllSaleItems(): List<SaleItem>

    fun getSaleItemById(id:Int): SaleItem

    suspend fun insertSaleItem(saleItem: SaleItem)

    suspend fun updateSaleItem(saleItem: SaleItem)
}