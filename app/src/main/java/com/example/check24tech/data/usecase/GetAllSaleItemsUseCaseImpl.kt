package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItem
import com.example.check24tech.domain.usecase.GetAllSaleItemsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GetAllSaleItemsUseCaseImpl(private val repository: Repository): GetAllSaleItemsUseCase {
    override fun getAllSaleItems(): Flow<List<SaleItem>> {
        return repository.getAllSaleItems()
    }
}