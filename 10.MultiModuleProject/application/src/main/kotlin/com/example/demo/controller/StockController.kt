package com.example.demo.controller

import com.example.demo.library.stock.StockPrice // implementationで使用されている為、インポートできる
import com.example.demo.library.stock.StockService // 実際にはAppConfig.ktによってMockStockServiceが呼び出される
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import org.springframework.format.annotation.DateTimeFormat

@RestController
class StockController(
    private val stockService: StockService
) {
    @GetMapping("/api/stocks/{symbol}/history")
    fun getStockHistory(
        @PathVariable symbol: String,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) startDate: LocalDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) endDate: LocalDate
    ): List<StockPrice> {
        return stockService.getHistoricalPrices(symbol, startDate, endDate)
    }

    @GetMapping("/api/stocks/{symbol}/current")
    fun getCurrentStockPrice(@PathVariable symbol: String): StockPrice? {
        return stockService.getCurrentPrice(symbol)
    }
}
