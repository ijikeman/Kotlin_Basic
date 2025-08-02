package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

import com.example.demo.service.UserService // ユーザー情報を操作するリポジトリをインポート

@Controller
class LoginController(
    private val userService: UserService
) {
    @GetMapping("/users")
    fun users(model: Model): String {
        val users = userService.findAll() // 前回定義したメソッド名に合わせる
        model.addAttribute("users", users)
        return "users" // users.htmlテンプレートを返す
    }
}
