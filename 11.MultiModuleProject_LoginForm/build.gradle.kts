plugins {
    // Kotlin JVMプラグインのバージョンを定義
    kotlin("jvm") version "2.2.0"
    // Springの依存関係管理プラグインのバージョンを定義
    id("io.spring.dependency-management") version "1.1.7"
    // Spring Bootプラグインのバージョンを定義
    id("org.springframework.boot") version "3.5.3"
    // KotlinとSpringを連携させるプラグインのバージョンを定義
    id("org.jetbrains.kotlin.plugin.spring") version "2.2.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
