package com.example.whenlambo.remote.service

import com.example.whenlambo.remote.model.LatestCryptocurrenciesResponseDto
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitCryptocurrencyService {
    @Headers("X-CMC_PRO_API_KEY: fbd6208e-741b-41a0-813f-2b0ffb902356")
    @GET("cryptocurrency/listings/latest")
    fun getLatestCryptocurrenciesResponse() : Single<LatestCryptocurrenciesResponseDto>

    companion object {
        val BASE_URL = "https://pro-api.coinmarketcap.com/v1/"

        fun create() : RetrofitCryptocurrencyService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create()
                ).addConverterFactory(
                    GsonConverterFactory.create()
                ).baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitCryptocurrencyService::class.java)
        }
    }
}

fun main() {
    val service = RetrofitCryptocurrencyService.create()
    service.getLatestCryptocurrenciesResponse()
        .subscribe (
            {it -> print(it)}, {it -> print("Error")}
        )
    service.getLatestCryptocurrenciesResponse()
}