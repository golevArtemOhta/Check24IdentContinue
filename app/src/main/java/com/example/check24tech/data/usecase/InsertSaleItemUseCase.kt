package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItem

class InsertSaleItemUseCase(private val repository: Repository) {
    suspend fun insertSaleItem(saleItem: SaleItem){
        repository.insertSaleItem(saleItem)
    }
}