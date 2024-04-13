package com.example.check24tech.domain.mapper

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import coil.map.Mapper
import com.example.check24tech.data.model.SaleItemDto
import com.example.check24tech.domain.model.SaleItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SaleItemMapper: com.example.check24tech.common.Mapper<SaleItemDto, SaleItemModel>{
    override fun mapFromDataToDomain(from: SaleItemDto): SaleItemModel {
        return SaleItemModel(
            id = from.id,
            title = from.title,
            description = from.description,
            price = from.price,
            image = from.image
        )
    }

    override fun mapFromDomainToData(from: SaleItemModel): SaleItemDto {
        return SaleItemDto(
            id = from.id,
            title = from.title,
            description = from.description,
            price = from.price,
            image = from.image
        )
    }

    override fun dataToDomainFlow(from: Flow<SaleItemDto>): Flow<SaleItemModel> {
        return from.map { mapFromDataToDomain(it) }
    }

    override fun listOfDataToDomainFlow(listData: Flow<List<SaleItemDto>>): Flow<List<SaleItemModel>> {
        return listData.map { it -> it.map { mapFromDataToDomain(it) } }
    }

}