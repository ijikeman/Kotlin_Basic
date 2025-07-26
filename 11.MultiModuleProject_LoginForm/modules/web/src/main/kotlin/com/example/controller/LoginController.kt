package com.example.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import com.example.model.User
import com.example.service.UserService

@Controller
class LoginController {
    @GetMapping("/login")
    fun loginForm(): String = "login"

    @PostMapping("/login")
    fun loginProcess(@RequestParam username: String, @RequestParam password: String): String {
        // ログイン処理本体を書く
        // 例：ユーザー検索・認証・リダイレクトなど
        return "redirect:/"
    }
}
