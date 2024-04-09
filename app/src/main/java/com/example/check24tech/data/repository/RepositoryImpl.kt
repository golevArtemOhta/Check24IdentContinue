package com.example.check24tech.data.repository

import com.example.check24tech.data.db.ItemsDao
import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItem

class RepositoryImpl(private val itemsDao: ItemsDao) : Repository {
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