package com.example.checkidenttask.data.usecase

import com.example.checkidenttask.domain.Repository
import com.example.checkidenttask.domain.model.SaleItem
import com.example.check24tech.domain.usecase.GetAllSaleItemsUseCase

class GetAllSaleItemsUseCaseImpl(private val repository: Repository): GetAllSaleItemsUseCase {
    override fun getAllSaleItems(): List<SaleItem>{
        return repository.getAllSaleItems()
    }
}