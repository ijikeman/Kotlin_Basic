package com.example.stockanalysis.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.stockanalysis"])
fun main(args: Array<String>) {
    runApplication<WebApplication>(*args)
}