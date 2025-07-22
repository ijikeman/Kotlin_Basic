package com.example.demo.service

import org.springframework.stereotype.Service

import com.example.demo.entity.User // Userエンティティをインポート
import com.example.demo.repository.UserRepository // ユーザー情報を操作するリポジトリをインポート

@Service
class UserService(private val userRepository: UserRepository) { // ユーザー情報を操作するサービスクラス
    fun findByUsername(name: String): User? { // ユーザー名でユーザーを検索するメソッド
        return userRepository.findByUsername(username) // リポジトリを使用してユーザーを検索
    }
}
