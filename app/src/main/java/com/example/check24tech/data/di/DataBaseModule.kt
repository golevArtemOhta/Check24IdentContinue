package com.example.check24tech.data.di

import androidx.room.Room
import com.example.check24tech.data.db.AppDatabase
import com.example.check24tech.data.repository.RepositoryImpl
import com.example.check24tech.domain.Repository
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    single { get<AppDatabase>().itemsDao() }
    single<Repository> { RepositoryImpl(get()) }
}

























