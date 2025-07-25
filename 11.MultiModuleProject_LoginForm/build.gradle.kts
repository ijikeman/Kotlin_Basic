plugins {
    kotlin("jvm") version "2.2.0" apply false // Kotlin version
    id("org.springframework.boot") version "3.5.3" apply false
    id("io.spring.dependency-management") version "1.1.7" // from Gradle Plugin Portal
}

allprojects {
    group = "com.example"
    version = "0.1.0"
    repositories {
        mavenCentral()
    }
}
