package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

import com.example.demo.service.UserService // ユーザー情報を操作するリポジトリをインポート
import com.example.demo.entity.User // 登録で利用する為、UserEntityをimport

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

    @PostMapping("/users")
    fun register_users(
        @RequestParam("name") name: String, // 引数としてnameを受け取る
        model: Model
    ): String {
        val newUser = User(name = name) // 引数nameで新しいユーザエンティティを作成
        userService.registerUser(newUser) // 新しいユーザを登録

        // 登録後、再度ユーザー一覧ページにリダイレクト
        // リダイレクトすることで、ページの再読み込み時にPOSTが再送信されるのを防げます
        // またリダイレクトすることで@GetMapping("/users")が実行される為、ユーザの一覧が表示できる
        return "redirect:/users"
    }
}
