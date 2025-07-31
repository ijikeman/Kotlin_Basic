package com.example.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.ui.Model
import org.springframework.security.core.Authentication // Spring-Securityを使う
import org.springframework.security.crypto.password.PasswordEncoder // 平文対応のため不要なインポートは削除またはコメントアウト
import com.example.UserRepository // UserRepositoryを参照させる必要がある

@Controller
class AuthController (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @GetMapping("/") // トップページ
    fun index(model: Model): String {
        model.addAttribute("message", "Hello World!")
        return "index"
    }

    @GetMapping("/login")
    fun login(): String {
        return "login" // src/main/resources/templates/login.html をレンダリング
    }

    @GetMapping("/secret") // 認証後のジャンプページ
    fun home(authentication: Authentication, model: Model): String {
        return "secret"
    }
}
