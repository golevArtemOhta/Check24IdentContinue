package com.example.check24tech.domain.usecase

import com.example.check24tech.domain.model.SaleItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface GetAllSaleItemsUseCase {

    fun getAllSaleItems(): Flow<List<SaleItem>>
}