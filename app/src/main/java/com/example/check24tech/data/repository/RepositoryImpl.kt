package com.example.check24tech.data.repository

import com.example.check24tech.data.db.ItemsDao
import com.example.check24tech.domain.Repository
import com.example.check24tech.data.model.SaleItemDto
import com.example.check24tech.domain.mapper.SaleItemMapper
import com.example.check24tech.domain.model.SaleItemModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val itemsDao: ItemsDao, private val saleItemMapper: SaleItemMapper) : Repository {
    override fun getAllSaleItems(): Flow<List<SaleItemModel>> {
        return saleItemMapper.listOfDataToDomainFlow(itemsDao.getAllItems())
    }

    override fun getSaleItemById(id: Int): Flow<SaleItemModel> {
        return saleItemMapper.dataToDomainFlow(itemsDao.getItemById(id))
    }

    override suspend fun insertSaleItem(saleItemDto: SaleItemDto) {
        itemsDao.insertSaleItem(saleItemDto)
    }

    override suspend fun updateSaleItem(saleItemDto: SaleItemDto) {
        itemsDao.updateSaleItem(saleItemDto)
    }
}