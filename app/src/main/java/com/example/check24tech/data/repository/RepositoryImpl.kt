package com.example.check24tech.data.repository

import com.example.check24tech.data.db.ItemsDao
import com.example.check24tech.data.mapper.SaleItemMapper
import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItemModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val itemsDao: ItemsDao, private val saleItemMapper: SaleItemMapper) :
    Repository {
    override fun getAllSaleItems(): Flow<List<SaleItemModel>> {
        return saleItemMapper.listOfDataToDomainFlow(itemsDao.getAllItems())
    }

    override fun getSaleItemById(id: Int): Flow<SaleItemModel> {
        return saleItemMapper.dataToDomainFlow(itemsDao.getItemById(id))
    }

    override suspend fun insertSaleItem(saleItemModel: SaleItemModel) {
        itemsDao.insertSaleItem(saleItemMapper.mapFromDomainToData(saleItemModel))
    }

    override suspend fun updateSaleItem(saleItemModel: SaleItemModel) {
        itemsDao.updateSaleItem(saleItemMapper.mapFromDomainToData(saleItemModel))
    }
}