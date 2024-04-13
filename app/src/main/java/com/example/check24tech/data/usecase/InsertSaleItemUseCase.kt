package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.data.model.SaleItemDto

class InsertSaleItemUseCase(private val repository: Repository) {
    suspend fun insertSaleItem(saleItemDto: SaleItemDto){
        repository.insertSaleItem(saleItemDto)
    }
}