package com.example.whenlambo.app.ui.home

import com.example.whenlambo.data.model.CryptocurrencyEntity

interface HomeContract {
    interface Presenter : HomeContract {
        fun onViewCreated()
        fun onDestroyView()
    }
    interface View : HomeContract {
        fun showCryptocurrencies(items : List<CryptocurrencyEntity?>)

    }
}