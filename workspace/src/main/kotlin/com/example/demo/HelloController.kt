package com.example.demo

import org.springframework.web.bind.annotation.GetMapping

//import org.springframework.web.bind.annotation.RestController
import org.springframework.stereotype.Controller // @RestController から @Controller に変更

import org.springframework.web.bind.annotation.PostMapping // PostParameter追加
import org.springframework.ui.Model // Parameter渡し
import org.springframework.web.bind.annotation.RequestParam // Parameter渡し

import org.springframework.beans.factory.annotation.Value // ★追加

//@RestController
@Controller
class HelloController {

    // ★追加
    // application.propertiesからapp.base-urlプロパティを読み込む
    // プロファイルがdevcontainerの場合、application-devcontainer.propertiesの値が優先される
    @Value("\${app.base-url:}") // デフォルト値を空文字に設定（プロパティがない場合）
    private lateinit var appBaseUrl: String

    @GetMapping("/")
    // fun hello(): String = "Hello, World!(Spring Boot)"
    // fun hello(): String {
    fun hello(model: Model): String {
        model.addAttribute("inputName", "")

        // ★追加
        // appBaseUrl が設定されていればそれを使用し、そうでなければ相対パス（"/"）を使用
        val postUrl = if (appBaseUrl.isNotBlank()) {
            "$appBaseUrl/" // 例: http://localhost/proxy/8080/
        } else {
            "/" // 例: / (通常の環境)
        }
        return "hello" // src/main/resources/templates/hello.htmlを返す
    }

    // POSTリクエストでフォーム送信されたときの処理
    @PostMapping("/")
    // 受け取ったuserNameを使ってメッセージを作成し、Modelに追加
    fun helloPost(@RequestParam("userName") userName: String, model: Model): String {
        model.addAttribute("inputName", userName)  // 入力フォームに現在の値を保持
        return "confirm"
    }
}
