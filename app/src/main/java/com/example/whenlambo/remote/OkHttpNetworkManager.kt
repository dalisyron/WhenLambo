package com.example.whenlambo.remote

import com.example.whenlambo.remote.OkHttpNetworkManager.Companion.URL_LATEST
import okhttp3.OkHttpClient
import okhttp3.Request


class OkHttpNetworkManager {
    private val client = OkHttpClient()

    fun get(url: String) : String? {

        val request = Request.Builder()
            .header("X-CMC_PRO_API_KEY", API_KEY)
            .url(url)
            .build()
        return client.newCall(request).execute().body()?.string()
    }

    companion object {
        //pls no steal me api key plssssssss
        val URL_LATEST = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest"
        val API_KEY = "fbd6208e-741b-41a0-813f-2b0ffb902356"
    }
}

fun main() {
    val nm = OkHttpNetworkManager()
    print(nm.get(URL_LATEST))
}