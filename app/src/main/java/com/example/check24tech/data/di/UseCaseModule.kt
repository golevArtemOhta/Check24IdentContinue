package com.example.checkidenttask.data.di

import com.example.checkidenttask.data.usecase.GetAllSaleItemsUseCaseImpl
import com.example.checkidenttask.data.usecase.GetSaleItemByIdUseCaseImpl
import com.example.checkidenttask.data.usecase.InsertSaleItemUseCase
import com.example.checkidenttask.data.usecase.UpdateSaleItemUseCase
import com.example.check24tech.domain.usecase.GetAllSaleItemsUseCase
import com.example.check24tech.domain.usecase.GetSaleItemByIdUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetAllSaleItemsUseCase> { GetAllSaleItemsUseCaseImpl(get()) }
    factory<GetSaleItemByIdUseCase> { GetSaleItemByIdUseCaseImpl(get()) }
    factory<InsertSaleItemUseCase> { InsertSaleItemUseCase(get()) }
    factory<UpdateSaleItemUseCase> { UpdateSaleItemUseCase(get()) }


}