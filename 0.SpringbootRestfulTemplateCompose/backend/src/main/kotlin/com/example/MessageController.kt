package com.example

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {

    @GetMapping("/api/hello/{lang}")
    fun hello(@PathVariable lang: String): String {
        return when (lang) {
            "us" -> "Hello World"
            "jp" -> "こんにちは"
            else -> "Unknown language"
        }
    }
}
