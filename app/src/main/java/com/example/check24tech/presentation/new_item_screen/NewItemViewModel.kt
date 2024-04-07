package com.example.checkidenttask.presentation.new_item_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkidenttask.domain.model.SaleItem
import com.example.checkidenttask.data.usecase.InsertSaleItemUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewItemViewModel(private val insertSaleItemUseCase: InsertSaleItemUseCase): ViewModel() {

    data class UIStateHero(val saleItem: SaleItem? = null)

    fun insertSaleItem(saleItem: SaleItem?) {
        viewModelScope.launch {

            if (saleItem != null) {
                insertSaleItemUseCase.insertSaleItem(saleItem)
            }
        }
    }
}