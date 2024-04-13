package com.example.check24tech.data.usecase

import com.example.check24tech.domain.Repository
import com.example.check24tech.domain.model.SaleItemModel

class InsertSaleItemUseCase(private val repository: Repository) {
    suspend fun insertSaleItem(saleItemModel: SaleItemModel) {
        repository.insertSaleItem(saleItemModel)
    }
}