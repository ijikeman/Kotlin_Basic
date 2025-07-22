package com.example.myapp  // プロジェクトの実際のパッケージに置き換える

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// Spring Bootの主要設定を持つクラス（エントリポイント）
@SpringBootApplication
class MyAppApplication

fun main(args: Array<String>) {
    runApplication<MyAppApplication>(*args)
}
