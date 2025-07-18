package com.example.demo

import org.springframework.web.bind.annotation.GetMapping

import org.springframework.stereotype.Controller // @RestController から @Controller に変更

import org.springframework.web.bind.annotation.PostMapping // PostParameter追加
import org.springframework.ui.Model // Parameter渡し
import org.springframework.web.bind.annotation.RequestParam // Parameter渡し

// import org.springframework.beans.factory.annotation.Autowired // ★AutoWiredでServiceを宣言するならこれ
import org.slf4j.LoggerFactory // ロギングを追加
import org.springframework.beans.factory.annotation.Value // ★追加

//@RestController
@Controller
class HelloController(
    private val greetingService: GreetingService // Serviceをコンストラクタ変数で宣言
) {
    // ★ここが重要です！loggerインスタンスの定義
    private val logger = LoggerFactory.getLogger(HelloController::class.java)
    // ★追加
    // application.propertiesからapp.base-urlプロパティを読み込む
    // プロファイルがdevcontainerの場合、application-devcontainer.propertiesの値が優先される
    @Value("\${app.base-url:}") // デフォルト値を空文字に設定（プロパティがない場合）
    private lateinit var appBaseUrl: String

    // @Autowired ★AutoWiredでServiceを宣言するならこれ
    // private lateinit var greetingService: GreetingService

    @GetMapping("/")
    fun hello(model: Model): String {
        model.addAttribute("inputName", "")
        logger.info("GET /: hello.htmlを返します。") // ログ出力

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
        logger.info("POST /: userNameとして '{}' を受け取りました。", userName) // 受け取ったパラメータをログ出力
        val greeting = greetingService.greet(userName) // greetingServiceを使う
        model.addAttribute("greeting", greeting)
        model.addAttribute("inputName", userName)  // 入力フォームに現在の値を保持
        logger.info("Modelに 'inputName' = '{}' を追加しました。", userName) // Modelに追加した値をログ出力
        return "confirm"
    }
}
