plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.spring")
}

// stockモジュールは、株価情報の取得や管理など、株式関連のビジネスロジックを担当します。
dependencies {
    // coreモジュールに依存し、共通のエンティティやクラスを利用します。
    implementation(project(":modules:core"))

    // Spring Bootの基本機能
    implementation("org.springframework.boot:spring-boot-starter")
    // Spring Data JPAによるデータベースアクセス
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // 外部APIとの通信用にSpring WebFlux (WebClient) を利用します。
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // テスト用の依存関係
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}