plugins {
    kotlin("jvm") version "2.2.0" // Kotlin version
    kotlin("plugin.spring") version "2.2.0" // Kotlin version
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7" // from Gradle Plugin Portal
    // kotlin("plugin.jpa") version "2.2.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf") // Template Engineを追加
    // implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.h2database:h2")
}
