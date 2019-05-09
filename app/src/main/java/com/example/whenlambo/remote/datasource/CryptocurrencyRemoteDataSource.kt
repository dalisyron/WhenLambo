package com.example.whenlambo.remote.datasource

import com.example.whenlambo.remote.model.CryptocurrencyDto
import com.example.whenlambo.remote.service.CryptocurrencyService
import com.example.whenlambo.remote.service.RetrofitCryptocurrencyService
import io.reactivex.Single

class CryptocurrencyRemoteDataSource(private val retrofitCryptocurrencyService: RetrofitCryptocurrencyService) {
    fun getLatestCryptocurrencies() : Single<List<CryptocurrencyDto?>> {
        return retrofitCryptocurrencyService.getLatestCryptocurrenciesResponse().flatMap {
            it -> Single.just(it.data)
        }
    }
}