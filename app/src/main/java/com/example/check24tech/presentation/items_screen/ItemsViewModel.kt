package com.example.check24tech.presentation.items_screen

import androidx.lifecycle.ViewModel
import com.example.check24tech.domain.usecase.GetAllSaleItemsUseCase

class ItemsViewModel(private val getAllSaleItemsUseCase: GetAllSaleItemsUseCase) : ViewModel() {

    val saleItemsList = getAllSaleItemsUseCase.getAllSaleItems()

}
