package com.example

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @CrossOrigin(origins = ["http://localhost:5173"])
    @GetMapping("/")
    fun hello(): String {
        return "Hello World"
    }
}
