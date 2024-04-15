package com.example.check24tech.domain.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItemModel
import kotlinx.coroutines.flow.Flow

class GetSaleItemByIdUseCase(private val repository: Repository) {
    fun getSaleItemById(id: Int): Flow<SaleItemModel> {
        return repository.getSaleItemById(id)
    }
}