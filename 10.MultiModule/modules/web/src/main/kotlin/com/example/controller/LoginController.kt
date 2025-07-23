package com.example

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.stereotype.Controller // @RestController から @Controller に変更

//@RestController
@Controller
class LoginController {

    @GetMapping("/")
    fun login(): String {
        return "login"
    }
}
