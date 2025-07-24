package com.example.demo.library.stock

import java.time.LocalDate

data class StockPrice(
    val symbol: String,      // 銘柄コード (例: 7203.T for Toyota)
    val date: LocalDate,     // 日付
    val open: Double,        // 始値
    val high: Double,        // 高値
    val low: Double,         // 安値
    val close: Double,       // 終値
    val volume: Long         // 出来高
)
