package com.example.checkidenttask.data.di

import com.example.checkidenttask.presentation.items_screen.ItemsViewModel
import com.example.checkidenttask.presentation.new_item_screen.NewItemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ItemsViewModel(get()) }
    viewModel { NewItemViewModel(get()) }
}