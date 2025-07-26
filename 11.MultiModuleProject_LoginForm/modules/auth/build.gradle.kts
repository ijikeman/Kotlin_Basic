plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.spring")
}

// authモジュールは、ユーザー認証や認可に関連する機能を担当します。
// Spring Securityや関連する依存関係を設定します。
dependencies {
    // coreモジュールに依存し、共通のエンティティやクラスを利用します。
    implementation(project(":modules:core"))

    // Spring Bootの基本機能
    implementation("org.springframework.boot:spring-boot-starter")
    // Spring Securityによる認証・認可機能
    implementation("org.springframework.boot:spring-boot-starter-security")
    // Spring Data JPAによるデータベースアクセス
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // テスト用の依存関係
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}