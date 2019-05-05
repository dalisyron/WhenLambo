package com.example.whenlambo.remote.service

import com.example.whenlambo.remote.NetworkManager
import com.example.whenlambo.remote.model.LatestCryptocurrenciesResponseDto
import com.google.gson.Gson

class CryptocurrencyService(private val networkManager: NetworkManager) {

    fun getLatestCryptoCurrencies() : LatestCryptocurrenciesResponseDto {
        var rawResponse = networkManager.get(URL_LATEST)
        return Gson().fromJson(rawResponse, LatestCryptocurrenciesResponseDto::class.java)
    }

    companion object {
        val URL_LATEST = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest"
    }
}
