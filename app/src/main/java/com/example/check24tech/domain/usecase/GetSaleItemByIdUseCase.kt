package com.example.check24tech.domain.usecase

import com.example.check24tech.domain.model.SaleItemModel
import kotlinx.coroutines.flow.Flow

interface GetSaleItemByIdUseCase {

    fun getSaleItemById(id: Int): Flow<SaleItemModel>
}