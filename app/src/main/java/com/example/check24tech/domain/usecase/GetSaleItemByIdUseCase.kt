package com.example.check24tech.domain.usecase

import com.example.checkidenttask.domain.model.SaleItem

interface GetSaleItemByIdUseCase {

    fun getSaleItemById(id:Int): SaleItem
}