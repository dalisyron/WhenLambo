package com.example.whenlambo.data.mapper

import com.example.whenlambo.data.model.CryptocurrencyEntity
import com.example.whenlambo.remote.model.CryptocurrencyDto

fun CryptocurrencyDto.toCryptocurrencyEntity() : CryptocurrencyEntity{
    return CryptocurrencyEntity(
        name = this.name,
        price = this.quote.USD.price.toFixedDecimal(2),
        percentChange24H = this.quote.USD.percent_change_24h.toFixedDecimal(2),
        cmcRank = this.cmc_rank
    )
}

fun Double.toFixedDecimal(count : Int) : Double {
    return String.format("%.${count}f", this).toDouble()
}