plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":modules:core"))
    implementation(project(":modules:auth"))
    implementation(project(":modules:stock"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.mysql:mysql-connector-j")
}

springBoot {
    mainClass.set("com.example.stockanalysis.web.WebApplicationKt")
}