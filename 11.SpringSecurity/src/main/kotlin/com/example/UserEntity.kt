package com.example

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Column // @Column を使う場合はインポートしておきましょう

@Entity
data class UserEntity( // ここにプロパティを定義します
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0, // IDは自動生成されるのでデフォルト値 0 を設定

    @Column(nullable = false, unique = true) // DBカラム設定: null不可、ユニーク
    val name: String, // ユーザー名。変更しない場合は val でOK

    @Column(nullable = false) // DBカラム設定: null不可
    var password: String, // パスワード（平文の場合）。変更の可能性があるので var

    @Column(nullable = false) // DBカラム設定: null不可
    //var roles: String // ロール。変更の可能性があるので var
    var roles: String = "USER" // USERロールを強制定義
)
