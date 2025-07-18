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
    private val greetingService: GreetingService,
    private val errorMessage: ErrorMessage // Inject ErrorMessage
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
    fun helloPost(@RequestParam("userName") userName: String, model: Model): String {
        val validationResult = greetingService.validateName(userName)

        return when (validationResult) {
            is ValidationResult.Success -> {
                val greeting = greetingService.greet(userName)
                model.addAttribute("greeting", greeting)
                model.addAttribute("inputName", userName)
                "confirm"
            }
            is ValidationResult.Error -> {
                logger.warn("Invalid inputName: $userName. ${validationResult.message}")
                model.addAttribute("errorMessage", validationResult.message)
                "hello"
            }
        }
    }
}
