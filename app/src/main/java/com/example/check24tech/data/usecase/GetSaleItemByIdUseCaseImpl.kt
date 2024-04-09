package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItem
import com.example.check24tech.domain.usecase.GetSaleItemByIdUseCase

class GetSaleItemByIdUseCaseImpl(private val repository: Repository): GetSaleItemByIdUseCase {
    override fun getSaleItemById(id:Int): SaleItem {
        return repository.getSaleItemById(id)
    }
}