package com.example.check24tech.data.di

import com.example.check24tech.presentation.items_screen.ItemsViewModel
import com.example.check24tech.presentation.new_item_screen.NewItemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ItemsViewModel(get()) }
    viewModel { NewItemViewModel(get(), get(), get()) }
}