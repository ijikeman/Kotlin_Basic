package com.example.demo.entity

// リレーショナルデータベース（RDB）とやりとりするための「標準API仕様＝Jakarta Persistence（JPA）」を定義しているパッケージ
import jakarta.persistence.*

@Entity // エンティティクラスを示すアノテーション
@Table(name = "users") // テーブル名を指定
data class User(
    @Id // 主キーを示すアノテーション
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主キーの生成戦略を指定（自動インクリメント）
    val id: Long = 0, // 主キーのID

    @Column(nullable = false, unique = true, length = 50) // カラムの設定（null不可、一意制約、最大長）
    val name: String = "", // ユーザー名

    @Column(nullable = false, length = 255)
    val password: String = "", // パスワード
)
