package com.example.checkidenttask.domain

import com.example.checkidenttask.domain.model.SaleItem

interface Repository {

    fun getAllSaleItems(): List<SaleItem>

    fun getSaleItemById(id:Int): SaleItem

    suspend fun insertSaleItem(saleItem: SaleItem)

    suspend fun updateSaleItem(saleItem: SaleItem)
}