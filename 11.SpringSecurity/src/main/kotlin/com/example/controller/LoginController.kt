package com.example.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.ui.Model
import org.springframework.security.core.Authentication // Spring-Securityを使う
import org.springframework.security.crypto.password.PasswordEncoder // 平文対応のため不要なインポートは削除またはコメントアウト
import com.example.UserRepository // UserRepositoryを参照させる必要がある
import com.example.UserEntity // UserEntityを追加
import org.springframework.web.bind.annotation.PostMapping

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

    @GetMapping("/register") // アカウント登録ページ
    fun registerUser(model: Model): String {
        model.addAttribute("userEntity", UserEntity(name = "", password = "", roles = "USER")) // 登録フォームに設定する空のUserEntityオブジェクトを追加
        return "register"
    }

    @PostMapping("/register")
    fun registerUser(userEntity: UserEntity): String {
        // パスワードのハッシュ化（今は平文ですが、後でBCryptに戻す場合はここにコードを追加）
        // val encodedPassword = passwordEncoder.encode(userEntity.password)
        // userRepository.save(userEntity.copy(password = encodedPassword, roles = "USER"))

        // 現時点では平文で保存し、ロールはデフォルトでUSERに設定
        userRepository.save(userEntity.copy())
        return "redirect:/login?registered" // 登録成功後、ログインページにリダイレクトしてメッセージ表示
    }
}
