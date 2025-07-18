package com.example.demo

class ErrorMessage {
    private val messages = mapOf(
        "invalidInputName" to "入力名は小文字のアルファベットのみで構成してください。"
    )

    fun getMessage(key: String): String {
        return messages.getOrDefault(key, "エラーが発生しました。")
    }
}
