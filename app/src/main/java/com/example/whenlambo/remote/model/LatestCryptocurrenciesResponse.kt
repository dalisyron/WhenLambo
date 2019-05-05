package com.example.whenlambo.remote.model

data class LatestCryptocurrenciesResponseDto(
    val data: List<CryptocurrencyDto?>,
    val status: Status
)

data class Status(
    val credit_count: Int,
    val elapsed: Int,
    val error_code: Int,
    val error_message: Any,
    val timestamp: String
)

data class CryptocurrencyDto(
    val circulating_supply: Double,
    val cmc_rank: Int,
    val date_added: String,
    val id: Int,
    val last_updated: String,
    val max_supply: Any,
    val name: String,
    val num_market_pairs: Int,
    val platform: Platform,
    val quote: Quote,
    val slug: String,
    val symbol: String,
    val tags: List<Any>,
    val total_supply: Double
)

data class Quote(
    val USD: USD
)

data class USD(
    val last_updated: String,
    val market_cap: Double,
    val percent_change_1h: Double,
    val percent_change_24h: Double,
    val percent_change_7d: Double,
    val price: Double,
    val volume_24h: Double
)

data class Platform(
    val id: Int,
    val name: String,
    val slug: String,
    val symbol: String,
    val token_address: String
)