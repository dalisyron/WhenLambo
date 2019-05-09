package com.example.whenlambo.app

import com.example.whenlambo.data.repository.CryptocurencyRepository
import com.example.whenlambo.remote.NetworkManager
import com.example.whenlambo.remote.OkHttpNetworkManager
import com.example.whenlambo.remote.datasource.CryptocurrencyRemoteDataSource
import com.example.whenlambo.remote.service.CryptocurrencyService

object Injector {
    fun provideCryptocurrencyRepository() : CryptocurencyRepository{
        return CryptocurencyRepository(CryptocurrencyRemoteDataSource(CryptocurrencyService(OkHttpNetworkManager())))
    }
}