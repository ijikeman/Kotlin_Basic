package com.example.demo.config

import com.example.demo.library.stock.MockStockService
import com.example.demo.library.stock.StockService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean // SpringのIoCコンテナに「このメソッドが返すオブジェクトを、DIの対象として管理してね」と指示するためのアノテーション
    fun stockService(): StockService { // もしStockService 型のインスタンスを必要としたら
        return MockStockService() // stockService() 関数が返す MockStockService のインスタンスを渡してあげてください。
    }
}
