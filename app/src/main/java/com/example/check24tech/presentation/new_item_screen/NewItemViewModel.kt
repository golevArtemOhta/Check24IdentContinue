package com.example.check24tech.presentation.new_item_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.check24tech.domain.usecase.GetSaleItemByIdUseCase
import com.example.check24tech.domain.model.SaleItem
import com.example.check24tech.data.usecase.InsertSaleItemUseCase
import com.example.check24tech.data.usecase.UpdateSaleItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewItemViewModel(
    private val insertSaleItemUseCase: InsertSaleItemUseCase,
    private val updateSaleItemUseCase: UpdateSaleItemUseCase,
    private val getSaleItemByIdUseCase: GetSaleItemByIdUseCase,
) : ViewModel() {

    private val _editSaleItem = MutableStateFlow<SaleItem?>(null)
    val editSaleItem: StateFlow<SaleItem?>
        get() = _editSaleItem

    fun insertSaleItem(saleItem: SaleItem?) {
        if (saleItem == null) return
        viewModelScope.launch(Dispatchers.IO) {

            insertSaleItemUseCase.insertSaleItem(saleItem)

        }
    }

    fun updateSaleItem(saleItem: SaleItem?) {
        if (saleItem == null) return
        viewModelScope.launch(Dispatchers.IO) {
            updateSaleItemUseCase.updateSaleItem(saleItem)
        }
    }

    fun initId(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getSaleItemByIdUseCase.getSaleItemById(id).let { saleItem ->
                _editSaleItem.update { saleItem }
            }
        }
    }
}