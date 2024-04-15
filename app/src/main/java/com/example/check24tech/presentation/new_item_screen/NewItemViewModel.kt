package com.example.check24tech.presentation.new_item_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.check24tech.data.model.SaleItemDto
import com.example.check24tech.domain.usecase.GetSaleItemByIdUseCase
import com.example.check24tech.domain.usecase.InsertSaleItemUseCase
import com.example.check24tech.domain.usecase.UpdateSaleItemUseCase
import com.example.check24tech.domain.model.SaleItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewItemViewModel(
    private val insertSaleItemUseCase: InsertSaleItemUseCase,
    private val updateSaleItemUseCase: UpdateSaleItemUseCase,
    private val getSaleItemByIdUseCase: GetSaleItemByIdUseCase,
) : ViewModel() {

    fun insertSaleItem(saleItemModel: SaleItemModel?) {
        if (saleItemModel == null) return
        viewModelScope.launch(Dispatchers.IO) {
            insertSaleItemUseCase.insertSaleItem(saleItemModel)
        }
    }

    fun updateSaleItem(saleItemModel: SaleItemModel?) {
        if (saleItemModel == null) return
        viewModelScope.launch(Dispatchers.IO) {
            updateSaleItemUseCase.updateSaleItem(saleItemModel)
        }
    }

    fun initId(id: Int): Flow<SaleItemModel> {
        return getSaleItemByIdUseCase.getSaleItemById(id)
    }
}