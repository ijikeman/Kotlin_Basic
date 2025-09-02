plugins {
    kotlin("jvm") version "2.0.10" // Kotlin version
    kotlin("plugin.spring") version "2.0.10" // Kotlin version
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7" // from Gradle Plugin Portal
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
}
