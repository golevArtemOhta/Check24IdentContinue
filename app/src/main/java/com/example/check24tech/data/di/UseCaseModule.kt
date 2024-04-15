package com.example.check24tech.data.di

import com.example.check24tech.domain.usecase.GetAllSaleItemsUseCase
import com.example.check24tech.domain.usecase.GetSaleItemByIdUseCase
import com.example.check24tech.domain.usecase.InsertSaleItemUseCase
import com.example.check24tech.domain.usecase.UpdateSaleItemUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetAllSaleItemsUseCase> { GetAllSaleItemsUseCase(get()) }
    factory<GetSaleItemByIdUseCase> { GetSaleItemByIdUseCase(get()) }
    factory<InsertSaleItemUseCase> { InsertSaleItemUseCase(get()) }
    factory<UpdateSaleItemUseCase> { UpdateSaleItemUseCase(get()) }
}