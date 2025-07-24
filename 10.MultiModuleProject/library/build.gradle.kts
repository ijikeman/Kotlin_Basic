plugins {
    kotlin("jvm") version "2.2.0"
    // id("io.spring.dependency-management") version "1.1.7" <--- この行を削除
}

group = "com.example.gs.multi.module"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

dependencies {
    // libraryモジュールはSpring Bootスターターの依存関係を持たない
    // 必要に応じてKotlinの標準ライブラリなどを追加
    // implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}