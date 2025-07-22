package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.ui.Model
import org.springframework.validation.annotation.Validated // バリデーションを有効にするためのアノテーションをインポート
import org.springframework.web.bind.annotation.* // 必要なアノテーションをインポート

import com.example.demo.entity.User // ユーザーエンティティをインポート
import com.example.demo.repository.UserRepository // ユーザー情報を操作するリポジトリをインポート

@Controller
class LoginController(
    private val userRepository: UserRepository // ユーザー情報を操作するリポジトリをコンストラクタインジェクションで受け取る
) {
    @GetMapping("/login")
    fun showLoginForm(model: Model): String {
        // フォームと紐付けるための空のUserオブジェクトを渡す
        model.addAttribute("user", User())
        return "login"
    }

    @PostMapping("/login")
    fun authenticateUser(
        @Validated @ModelAttribute user: User,  //バリデーションを有効にし、フォームの値をUserエンティティに紐付ける
        bindingResult: BindingResult, // バリデーションの結果を受け取るためのBindingResultを追加
        model: Model // モデルを受け取るための引数
    ): String {
        if (bindingResult.hasErrors()) { // バリデーションエラーがある場合
            // エラーがある場合は、入力値を保持したままログイン画面に戻る
            // BindingResultは自動でModelに追加される
            return "login" // ログインフォームを再表示
        }

        val dbUser = userRepository.findByName(user.name) // Repositoryを使用してユーザー名でユーザーを検索

        return if (dbUser != null && dbUser.password == user.password) { // ユーザーが存在し、パスワードが一致する場合
            model.addAttribute("name", dbUser.name)
            "confirm" // 認証成功
        } else {
            model.addAttribute("authenticationError", "ユーザー名またはパスワードが無効です。")
            "login" // 認証失敗時はエラーメッセージと共にログイン画面を再表示
        }
    }
}
