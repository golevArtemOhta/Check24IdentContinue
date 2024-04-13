package com.example.check24tech.presentation.items_screen

import androidx.lifecycle.ViewModel
import com.example.check24tech.domain.usecase.GetAllSaleItemsUseCase
import com.example.check24tech.data.model.SaleItemDto
import kotlinx.coroutines.flow.MutableStateFlow

class ItemsViewModel(private val getAllSaleItemsUseCase: GetAllSaleItemsUseCase) : ViewModel() {

    private val _saleItemsListDto = MutableStateFlow<List<SaleItemDto?>>(emptyList())
    val saleItemsList = getAllSaleItemsUseCase.getAllSaleItems()

}
