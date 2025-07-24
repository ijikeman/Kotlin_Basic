plugins {
    kotlin("jvm") version "2.2.0"
    kotlin("plugin.spring") version "2.2.0"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.springframework.boot") version "3.5.3"
}

group = "com.example.demo"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":library")) // ここでlibraryモジュールへの依存を宣言
}

// Spring Bootアプリケーションの起動クラスを指定します
tasks.getByName<org.springframework.boot.gradle.tasks.run.BootRun>("bootRun") {
    mainClass.set("com.example.demo.DemoApplicationKt") // あなたのSpring Bootアプリケーションのメインクラス名に合わせてください
}
