package com.example.checkidenttask.data.di

import android.adservices.adid.AdIdManager
import android.adservices.adid.AdIdManager.get
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.checkidenttask.data.db.AppDatabase
import com.example.checkidenttask.data.db.ItemsDao
import com.example.checkidenttask.data.repository.RepositoryImpl
import com.example.checkidenttask.domain.Repository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val databaseModule = module {


    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_database"
        ).build()
    }



    single{ get<AppDatabase>().itemsDao() }

    /*
//    single<ItemsDao> {
//        val database = get<AppDatabase>()
//        database.itemsDao()
//    }

//    factory<RoomDatabase> (named("app_database")){
//        get<AppDatabase> ()
//    }
//

//    single { provideDatabase(androidContext()) }
//    single { provideDao(get()) }
//    factory<Repository>{ RepositoryImpl(get()) }
//    factory { get<AppDatabase>().itemsDao() } */
    single<Repository> { RepositoryImpl(get()) }
}

























