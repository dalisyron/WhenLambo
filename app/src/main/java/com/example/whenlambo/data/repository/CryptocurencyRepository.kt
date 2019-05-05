package com.example.whenlambo.data.repository

import android.support.annotation.WorkerThread
import com.example.whenlambo.data.mapper.toCryptocurrencyEntity
import com.example.whenlambo.data.model.CryptocurrencyEntity
import com.example.whenlambo.remote.datasource.CryptocurrencyRemoteDataSource
import kotlin.concurrent.thread

class CryptocurencyRepository(private val cryptocurrencyRemoteDataSource: CryptocurrencyRemoteDataSource) {

    fun getLatestCryptocurrencies(success : (List<CryptocurrencyEntity?>) -> Unit) {
        thread {
            val cryptocurrencies = cryptocurrencyRemoteDataSource.getLatestCryptocurrencies()
            success(cryptocurrencies.map { it -> it?.toCryptocurrencyEntity()})
        }
    }
}