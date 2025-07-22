package com.example.demo.repository

import com.example.demo.entity.User // Userエンティティをインポート
import org.springframework.data.jpa.repository.JpaRepository // Spring Data JPAのリポジトリインターフェースをインポート

interface UserRepository : JpaRepository<User, Long> { // Userエンティティを操作するためのリポジトリインターフェース
    // ユーザー名でユーザーを検索するメソッド
    fun findByUsername(name: String): User?
}
