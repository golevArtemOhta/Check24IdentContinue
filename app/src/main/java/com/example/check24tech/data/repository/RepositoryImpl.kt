package com.example.checkidenttask.data.repository

import com.example.checkidenttask.data.db.ItemsDao
import com.example.checkidenttask.domain.Repository
import com.example.checkidenttask.domain.model.SaleItem

class RepositoryImpl(private val itemsDao: ItemsDao): Repository {
    override fun getAllSaleItems(): List<SaleItem> {
        return itemsDao.getAllItems()
    }

    override fun getSaleItemById(id: Int): SaleItem {
        return itemsDao.getItemById(id)
    }

    override suspend fun insertSaleItem(saleItem: SaleItem) {
        itemsDao.insertSaleItem(saleItem)
    }

    override suspend fun updateSaleItem(saleItem: SaleItem) {
        itemsDao.updateSaleItem(saleItem)
    }
}