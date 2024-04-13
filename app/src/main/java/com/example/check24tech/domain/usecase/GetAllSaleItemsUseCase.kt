package com.example.check24tech.domain.usecase

import com.example.check24tech.domain.model.SaleItemModel
import kotlinx.coroutines.flow.Flow

interface GetAllSaleItemsUseCase {

    fun getAllSaleItems(): Flow<List<SaleItemModel>>
}