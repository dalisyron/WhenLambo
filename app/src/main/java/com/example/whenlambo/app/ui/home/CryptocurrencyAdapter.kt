package com.example.whenlambo.app.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.whenlambo.R
import com.example.whenlambo.data.model.CryptocurrencyEntity

class CryptocurrencyAdapter(private var items : List<CryptocurrencyEntity?>) : RecyclerView.Adapter<CryptocurrencyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CryptocurrencyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_cryptocurrency_item, p0, false)
        return CryptocurrencyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(p0: CryptocurrencyViewHolder, p1: Int) {
        p0.bind(items[p1])
    }

}