package com.example.check24tech.domain.usecase

import com.example.check24tech.domain.model.SaleItem

interface GetAllSaleItemsUseCase {

    fun getAllSaleItems(): List<SaleItem>
}