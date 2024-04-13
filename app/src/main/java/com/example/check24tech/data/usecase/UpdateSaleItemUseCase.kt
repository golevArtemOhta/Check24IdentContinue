package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.data.model.SaleItemDto

class UpdateSaleItemUseCase(private val repository: Repository){
    suspend fun updateSaleItem(saleItemDto: SaleItemDto){
        repository.updateSaleItem(saleItemDto)
    }
}