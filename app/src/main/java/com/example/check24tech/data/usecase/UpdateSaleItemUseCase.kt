package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItem

class UpdateSaleItemUseCase(private val repository: Repository){
    suspend fun updateSaleItem(saleItem: SaleItem){
        repository.updateSaleItem(saleItem)
    }
}