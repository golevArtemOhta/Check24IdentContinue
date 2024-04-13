package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItemModel
import com.example.check24tech.domain.usecase.GetSaleItemByIdUseCase
import kotlinx.coroutines.flow.Flow

class GetSaleItemByIdUseCaseImpl(private val repository: Repository) : GetSaleItemByIdUseCase {
    override fun getSaleItemById(id: Int): Flow<SaleItemModel> {
        return repository.getSaleItemById(id)
    }
}