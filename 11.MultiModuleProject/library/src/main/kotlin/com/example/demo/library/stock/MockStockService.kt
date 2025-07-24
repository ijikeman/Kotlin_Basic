package com.example.demo.library.stock

import java.time.LocalDate

class MockStockService : StockService {
    override fun getHistoricalPrices(symbol: String, startDate: LocalDate, endDate: LocalDate): List<StockPrice> {
        // 仮のデータを返す (実際はAPIから取得する)
        if (symbol == "TEST") {
            return listOf(
                StockPrice("TEST", LocalDate.of(2025, 7, 21), 100.0, 105.0, 99.0, 103.0, 100000),
                StockPrice("TEST", LocalDate.of(2025, 7, 22), 103.0, 108.0, 102.0, 107.0, 120000),
                StockPrice("TEST", LocalDate.of(2025, 7, 23), 107.0, 110.0, 106.0, 109.0, 150000)
            ).filter { it.date in startDate..endDate }
        }
        return emptyList()
    }

    override fun getCurrentPrice(symbol: String): StockPrice? {
        // 仮のデータを返す
        return if (symbol == "TEST") {
            StockPrice("TEST", LocalDate.now(), 109.0, 112.0, 108.0, 111.0, 200000)
        } else {
            null
        }
    }
}
