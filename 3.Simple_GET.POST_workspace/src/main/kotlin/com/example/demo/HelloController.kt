package com.example.demo

import org.springframework.web.bind.annotation.GetMapping

import org.springframework.stereotype.Controller // @RestController から @Controller に変更

import org.springframework.web.bind.annotation.PostMapping // PostParameter追加
import org.springframework.ui.Model // Parameter渡し
import org.springframework.web.bind.annotation.RequestParam // Parameter渡し
import org.slf4j.LoggerFactory // ロギングを追加

//@RestController
@Controller
class HelloController {

    // ★ここが重要です！loggerインスタンスの定義
    private val logger = LoggerFactory.getLogger(HelloController::class.java)

    @GetMapping("/")
    fun hello(model: Model): String {
        model.addAttribute("inputName", "")
        logger.info("GET /: hello.htmlを返します。") // ログ出力
        return "hello" // src/main/resources/templates/hello.htmlを返す
    }

    // POSTリクエストでフォーム送信されたときの処理
    @PostMapping("/")
    // 受け取ったuserNameを使ってメッセージを作成し、Modelに追加
    fun helloPost(@RequestParam("userName") userName: String, model: Model): String {
        logger.info("POST /: userNameとして '{}' を受け取りました。", userName) // 受け取ったパラメータをログ出力
        model.addAttribute("inputName", userName)
        logger.info("Modelに 'inputName' = '{}' を追加しました。", userName) // Modelに追加した値をログ出力
        return "confirm"
    }
}
