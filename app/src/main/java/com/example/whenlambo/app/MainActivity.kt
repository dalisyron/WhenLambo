package com.example.whenlambo.app

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.whenlambo.R
import com.example.whenlambo.app.ui.home.HomeFragment
import com.example.whenlambo.data.model.CryptocurrencyEntity
import com.example.whenlambo.remote.NetworkManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Application.context = this
        /*
        var cryptocurrencyRepository = Injector.provideCryptocurrencyRepository()
        cryptocurrencyRepository.getLatestCryptocurrencies {
            it.forEach {
                println(it)
            }
        }
        */
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, HomeFragment())
            .commit()
    }

    fun onLatestCryptocurrenciesReady(cryptocurrencies : List<CryptocurrencyEntity>) {
        cryptocurrencies.forEach {
            println(it)
        }
    }
}
