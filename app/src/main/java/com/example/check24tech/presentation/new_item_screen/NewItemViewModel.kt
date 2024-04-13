package com.example.check24tech.presentation.new_item_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.check24tech.domain.usecase.GetSaleItemByIdUseCase
import com.example.check24tech.data.model.SaleItemDto
import com.example.check24tech.data.usecase.InsertSaleItemUseCase
import com.example.check24tech.data.usecase.UpdateSaleItemUseCase
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

    private val _editSaleItemDto = MutableStateFlow<SaleItemDto?>(null)
    val editSaleItemDto: StateFlow<SaleItemDto?>
        get() = _editSaleItemDto

    private val _title = mutableStateOf("")
    val title: State<String> = _title

    private val _description = mutableStateOf("")
    val description: State<String> = _description

    private val _price = mutableStateOf("0.0")
    val price: State<String> = _price

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