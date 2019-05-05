package com.example.whenlambo.app.ui.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.whenlambo.R
import com.example.whenlambo.data.model.CryptocurrencyEntity

class CryptocurrencyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val name : TextView = itemView.findViewById(R.id.name)
    val price : TextView = itemView.findViewById(R.id.price)
    val percentChange24 : TextView = itemView.findViewById(R.id.percentChange24)
    val rank : TextView = itemView.findViewById(R.id.rank)

    fun bind(cryptocurrencyEntity: CryptocurrencyEntity?) {
        name.text = cryptocurrencyEntity?.name
        price.text = cryptocurrencyEntity?.price.toString()
        percentChange24.text = cryptocurrencyEntity?.percentChange24H.toString()
        rank.text = cryptocurrencyEntity?.cmcRank.toString()
    }
}