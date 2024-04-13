package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.data.model.SaleItemDto
import com.example.check24tech.domain.model.SaleItemModel
import com.example.check24tech.domain.usecase.GetAllSaleItemsUseCase
import kotlinx.coroutines.flow.Flow

class GetAllSaleItemsUseCaseImpl(private val repository: Repository): GetAllSaleItemsUseCase {
    override fun getAllSaleItems(): Flow<List<SaleItemModel>> {
        return repository.getAllSaleItems()
    }
}