package com.example.checkidenttask.data.usecase

import com.example.checkidenttask.domain.Repository
import com.example.checkidenttask.domain.model.SaleItem

class UpdateSaleItemUseCase(private val repository: Repository){
    suspend fun updateSaleItem(saleItem: SaleItem){
        repository.updateSaleItem(saleItem)
    }
}