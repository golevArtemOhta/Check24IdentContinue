package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItemModel

class UpdateSaleItemUseCase(private val repository: Repository) {
    suspend fun updateSaleItem(saleItemModel: SaleItemModel) {
        repository.updateSaleItem(saleItemModel)
    }
}