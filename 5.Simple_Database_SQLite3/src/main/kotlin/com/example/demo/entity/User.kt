package com.example.demo.entity

data class User(
    val id: Long = 0, // 主キーのID
    var username: String = "", // ユーザー名
    var password: String = "", // パスワード
)
