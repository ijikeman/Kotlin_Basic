package com.example.demo

import org.springframework.web.bind.annotation.GetMapping

//import org.springframework.web.bind.annotation.RestController
import org.springframework.stereotype.Controller // @RestController から @Controller に変更

import org.springframework.web.bind.annotation.PostMapping // PostParameter追加
import org.springframework.ui.Model // Parameter渡し
import org.springframework.web.bind.annotation.RequestParam // Parameter渡し

//@RestController
@Controller
class HelloController {

    @GetMapping("/")
    // fun hello(): String = "Hello, World!(Spring Boot)"
    // fun hello(): String {
    fun hello(model: Model): String {
        model.addAttribute("inputName", "")
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
