package com.example.check24tech.presentation.new_item_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.check24tech.domain.model.SaleItemModel
import com.example.check24tech.domain.usecase.GetSaleItemByIdUseCase
import com.example.check24tech.domain.usecase.InsertSaleItemUseCase
import com.example.check24tech.domain.usecase.UpdateSaleItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
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