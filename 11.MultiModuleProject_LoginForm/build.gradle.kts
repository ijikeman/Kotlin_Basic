plugins {
    // Kotlin JVMプラグインのバージョンを定義
    id("org.jetbrains.kotlin.jvm") version "2.2.0" apply false
    // Spring Bootプラグインのバージョンを定義
    id("org.springframework.boot") version "3.5.3" apply false
    // Springの依存関係管理プラグインのバージョンを定義
    id("io.spring.dependency-management") version "1.1.7" apply false
    // KotlinとSpringを連携させるプラグインのバージョンを定義
    id("org.jetbrains.kotlin.plugin.spring") version "2.2.0" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}