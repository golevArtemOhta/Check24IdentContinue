package com.example.check24tech.presentation.items_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.check24tech.domain.usecase.GetAllSaleItemsUseCase
import com.example.check24tech.domain.model.SaleItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ItemsViewModel(private val getAllSaleItemsUseCase: GetAllSaleItemsUseCase) : ViewModel() {

    private val _saleItemsList = MutableStateFlow<List<SaleItem?>>(emptyList())
    val saleItemsList: StateFlow<List<SaleItem?>>
        get() = _saleItemsList

    init {
        getSaleItemsList()
    }

    private fun getSaleItemsList() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllSaleItemsUseCase.getAllSaleItems()?.let { list ->
                _saleItemsList.update { list }
            }
        }
    }
}
