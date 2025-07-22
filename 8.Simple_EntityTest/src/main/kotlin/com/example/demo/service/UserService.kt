package com.example.demo.service

import org.springframework.stereotype.Service

import com.example.demo.entity.User // Userエンティティをインポート
import com.example.demo.repository.UserRepository // ユーザー情報を操作するリポジトリをインポート

@Service
class UserService(private val userRepository: UserRepository) { // ユーザー情報を操作するサービスクラス
    fun findByName(name: String): User? { // ユーザー名でユーザーを検索するメソッド
        println("UserService.findByName called with name: $name")
        val user = userRepository.findByName(name) // リポジトリを使用してユーザーを検索
        println("UserService.findByName result: $user")
        return user
    }
}
