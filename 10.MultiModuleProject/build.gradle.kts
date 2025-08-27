plugins {
    kotlin("jvm") version "2.0.10" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
    id("org.springframework.boot") version "3.5.3" apply false
}

subprojects {
    repositories {
        mavenCentral()
    }
}
