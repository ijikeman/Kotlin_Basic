package com.example.demo.entity

data class User(
    val id: Long = 0, // 主キーのID
    val username: String = "", // ユーザー名
    val password: String = "", // パスワード
)
