package com.example.demo.library.stock

import java.time.LocalDate

interface StockService {
    /**
     * 指定された銘柄の、指定期間の株価データを取得する
     */
    fun getHistoricalPrices(symbol: String, startDate: LocalDate, endDate: LocalDate): List<StockPrice>

    /**
     * 指定された銘柄の現在の株価を取得する (もしAPIで取得可能なら)
     */
    fun getCurrentPrice(symbol: String): StockPrice?
}
