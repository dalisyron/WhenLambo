package com.example.whenlambo.remote.datasource

import com.example.whenlambo.remote.model.CryptocurrencyDto
import com.example.whenlambo.remote.service.CryptocurrencyService

class CryptocurrencyRemoteDataSource(private val cryptocurrencyService: CryptocurrencyService) {
    fun getLatestCryptocurrencies() : List<CryptocurrencyDto?> {
        return cryptocurrencyService.getLatestCryptoCurrencies().data
    }
}