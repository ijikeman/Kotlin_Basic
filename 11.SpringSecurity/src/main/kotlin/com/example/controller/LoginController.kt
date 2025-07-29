package com.example.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.ui.Model
import org.springframework.security.core.Authentication // Spring-Securityを使う

@Controller
class AuthController {

    @GetMapping("/login")
    fun login(
        @RequestParam(required = false) error: String?,
        @RequestParam(required = false) logout: String?,
        model: Model
    ): String {
        if (error != null) {
            model.addAttribute("error", "ログインに失敗しました")
        }
        if (logout != null) {
            model.addAttribute("message", "ログアウトしました")
        }
        return "login"
    }

    @GetMapping("/security")
    fun home(authentication: Authentication, model: Model): String {
        model.addAttribute("username", authentication.name)
        return "home"
    }
}
