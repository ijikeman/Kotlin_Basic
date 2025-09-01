package com.example

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

data class Message(val text: String)

@RestController
class MessageController {

    @GetMapping("/greeting")
    fun greeting(): Message {
        return Message("Hello from the backend!")
    }
}
