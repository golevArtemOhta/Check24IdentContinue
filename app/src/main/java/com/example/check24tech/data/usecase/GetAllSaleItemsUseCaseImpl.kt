package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItem
import com.example.check24tech.domain.usecase.GetAllSaleItemsUseCase

class GetAllSaleItemsUseCaseImpl(private val repository: Repository): GetAllSaleItemsUseCase {
    override fun getAllSaleItems(): List<SaleItem>{
        return repository.getAllSaleItems()
    }
}