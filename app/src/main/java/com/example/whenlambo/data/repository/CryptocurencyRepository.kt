package com.example.whenlambo.data.repository

import android.support.annotation.WorkerThread
import com.example.whenlambo.data.mapper.toCryptocurrencyEntity
import com.example.whenlambo.data.model.CryptocurrencyEntity
import com.example.whenlambo.remote.datasource.CryptocurrencyRemoteDataSource
import io.reactivex.Single
import kotlin.concurrent.thread

class CryptocurencyRepository(private val cryptocurrencyRemoteDataSource: CryptocurrencyRemoteDataSource) {

    fun getLatestCryptocurrencies() : Single<List<CryptocurrencyEntity?>> {
        return cryptocurrencyRemoteDataSource.getLatestCryptocurrencies()
            .flatMap {cryptos ->
                Single.just(cryptos.map {
                    it -> it?.toCryptocurrencyEntity()
                })
            }
    }
}