package com.example.check24tech.data.repository

import com.example.check24tech.data.db.ItemsDao
import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RepositoryImpl(private val itemsDao: ItemsDao) : Repository {
    override fun getAllSaleItems(): Flow<List<SaleItem>> {
        return itemsDao.getAllItems()
    }

    override fun getSaleItemById(id: Int): Flow<SaleItem> {
        return itemsDao.getItemById(id)
    }

    override suspend fun insertSaleItem(saleItem: SaleItem) {
        itemsDao.insertSaleItem(saleItem)
    }

    override suspend fun updateSaleItem(saleItem: SaleItem) {
        itemsDao.updateSaleItem(saleItem)
    }
}