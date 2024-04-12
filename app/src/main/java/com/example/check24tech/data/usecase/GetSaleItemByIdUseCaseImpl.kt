package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItem
import com.example.check24tech.domain.usecase.GetSaleItemByIdUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GetSaleItemByIdUseCaseImpl(private val repository: Repository): GetSaleItemByIdUseCase {
    override fun getSaleItemById(id:Int): Flow<SaleItem> {
        return repository.getSaleItemById(id)
    }
}