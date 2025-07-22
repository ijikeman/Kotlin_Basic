package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

import org.springframework.web.bind.annotation.ModelAttribute // フォームの値をエンティティに紐付けるためのアノテーションをインポート
import org.springframework.validation.annotation.Validated // バリデーションを有効にするためのアノテーションをインポート

import com.example.demo.entity.User // ユーザーエンティティをインポート
import com.example.demo.repository.UserRepository // ユーザー情報を操作するリポジトリをインポート

@Controller
class LoginController(
    private val userRepository: UserRepository // ユーザー情報を操作するリポジトリをコンストラクタインジェクションで受け取る
) {
    @GetMapping("/login")
    fun showLoginForm(model: Model): String {
        model.addAttribute("user", User()) // 新しいUserエンティティをモデルに追加し、エラーになるのを避ける
        return "login"
    }

    @PostMapping("/login")
    fun authenticateUser(
        @Validated //バリデーションを有効に
        @ModelAttribute user_entity: User, // フォームの値をUserエンティティに紐付ける
        bindingResult: BindingResult, // バリデーションの結果を受け取るためのBindingResultを追加
        model: Model // モデルを受け取るための引数
    ): String {
        if (bindingResult.hasErrors()) { // バリデーションエラーがある場合
            // エラーがある場合は、入力値を保持したままログイン画面に戻る
            // BindingResultは自動でModelに追加される
            return "login" // ログインフォームを再表示
        }

        val user = userRepository.findByName(user_entity.name) // Repositoryを使用してユーザー名でユーザーを検索

        return if (user != null && user_entity.password == user_entity.password) { // ユーザーが存在し、パスワードが一致する場合
            model.addAttribute("name", user_entity.name)
            "confirm" // 認証成功
        } else {
            model.addAttribute("authenticationError", "ユーザー名またはパスワードが無効です。")
            "login" // 認証失敗時はエラーメッセージと共にログイン画面を再表示
        }
    }
}
