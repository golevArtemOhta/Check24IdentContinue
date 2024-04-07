package com.example.checkidenttask.data.usecase

import com.example.checkidenttask.domain.Repository
import com.example.checkidenttask.domain.model.SaleItem

class InsertSaleItemUseCase(private val repository: Repository) {
    suspend fun insertSaleItem(saleItem: SaleItem){
        repository.insertSaleItem(saleItem)
    }
}