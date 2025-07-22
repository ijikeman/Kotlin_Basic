package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

import com.example.demo.repository.UserRepository // ユーザー情報を操作するリポジトリをインポート

@Controller
class LoginController(
    private val userRepository: UserRepository // ユーザー情報を操作するリポジトリをコンストラクタインジェクションで受け取る
) {
    @GetMapping("/login")
    fun showLoginForm(model: Model): String {
        model.addAttribute("error", true) // エラーメッセージを表示するための属性をモデルに追加
        return "login"
    }

    @PostMapping("/login")
    fun authenticateUser(username: String, password: String): String {
        val user = userRepository.findByUsername(name) // ユーザー名でユーザーを検索
        return if (user != null && user.password == password) { // ユーザーが存在し、パスワードが一致する場合
            return "confirm" // 認証成功時のリダイレクト先
        } else {
            "redirect:/login?error=true" // 認証失敗時のリダイレクト先
        }
    }
}
