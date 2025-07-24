package com.example.demo.config

import com.example.demo.library.stock.MockStockService
import com.example.demo.library.stock.StockService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean
    fun stockService(): StockService {
        return MockStockService()
    }
}
