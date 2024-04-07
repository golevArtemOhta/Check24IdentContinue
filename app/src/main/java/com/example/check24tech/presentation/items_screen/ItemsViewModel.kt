package com.example.checkidenttask.presentation.items_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.check24tech.domain.usecase.GetAllSaleItemsUseCase
import com.example.checkidenttask.domain.Repository
import com.example.checkidenttask.domain.model.SaleItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ItemsViewModel(private val getAllSaleItemsUseCase: GetAllSaleItemsUseCase) : ViewModel() {

    data class UIState(val saleItemsList: List<SaleItem> = emptyList())

    private val _saleItemsList = MutableStateFlow<UIState>(UIState())
    val saleItemsList: StateFlow<UIState>
        get() = _saleItemsList

    init {
        getSaleItemsList()
    }

    private fun getSaleItemsList() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllSaleItemsUseCase.getAllSaleItems()?.let { list ->
                _saleItemsList.update { it.copy(list) }
            }
        }
    }
}
