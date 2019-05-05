package com.example.whenlambo.remote

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.whenlambo.app.Application
import java.net.URL
import android.os.AsyncTask.execute
import com.example.whenlambo.remote.service.CryptocurrencyService
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import kotlin.concurrent.thread


class NetworkManager {

    fun get(url: String) : String{
        val obj = URL(url)
        val con = obj.openConnection() as HttpURLConnection
        con.setRequestMethod("GET")
        con.setRequestProperty("X-CMC_PRO_API_KEY", API_KEY)
        val inp = BufferedReader(
            InputStreamReader(con.getInputStream())
        )
        var inputLine: String?
        val response = StringBuffer()
        while (true) {
            inputLine = inp.readLine()
            if (inputLine == null) {
                break
            }
            response.append(inputLine)
        }
        inp.close()
        return response.toString()

    }

    companion object {
        val API_KEY = "fbd6208e-741b-41a0-813f-2b0ffb902356"
    }
}

fun main() {
    val nm = NetworkManager()
    println(nm.get(CryptocurrencyService.URL_LATEST))
}