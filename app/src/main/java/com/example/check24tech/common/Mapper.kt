package com.example.check24tech.common

import kotlinx.coroutines.flow.Flow

interface Mapper<F, T> {

    fun mapFromDataToDomain(from: F): T

    fun mapFromDomainToData(from: T): F

    fun dataToDomainFlow(from: Flow<F>): Flow<T>

    fun listOfDataToDomainFlow(listData: Flow<List<F>>): Flow<List<T>>

}