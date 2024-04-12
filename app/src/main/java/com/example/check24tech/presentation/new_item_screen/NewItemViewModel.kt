package com.example.check24tech.presentation.new_item_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.check24tech.domain.usecase.GetSaleItemByIdUseCase
import com.example.check24tech.domain.model.SaleItem
import com.example.check24tech.data.usecase.InsertSaleItemUseCase
import com.example.check24tech.data.usecase.UpdateSaleItemUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
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

    private val _title = mutableStateOf("")
    val title: State<String> = _title

    private val _description = mutableStateOf("")
    val description: State<String> = _description

    private val _price = mutableStateOf("0.0")
    val price: State<String> = _price

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

    fun initId(id: Int): Flow<SaleItem> {
        return getSaleItemByIdUseCase.getSaleItemById(id)
    }

    fun putEnteredData(
        title: String? = null,
        textDescription: String? = null,
        textPrice: String? = "0.0"
    ) {
        _title.value = title ?: ""
        _description.value = textDescription ?: ""
        _price.value = textPrice ?: "0.0"
    }
}