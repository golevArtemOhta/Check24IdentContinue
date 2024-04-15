package com.example.check24tech.domain.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItemModel
import kotlinx.coroutines.flow.Flow

class GetAllSaleItemsUseCase(private val repository: Repository)  {
    fun getAllSaleItems(): Flow<List<SaleItemModel>> {
        return repository.getAllSaleItems()
    }
}