package com.example

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JapaneseHelloController {

    @CrossOrigin(origins = ["http://localhost:5173"])
    @GetMapping("/hello/jp")
    fun helloJapanese(): String {
        return "こんにちは"
    }
}
