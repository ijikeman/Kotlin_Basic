plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.spring")
}

// webモジュールは、アプリケーションのエントリーポイントであり、Webインターフェースを担当します。
// 他のすべてのモジュール（core, auth, stock）に依存し、それらの機能を統合します。
dependencies {
    // 他のビジネスロジックモジュールに依存します。
    implementation(project(":modules:core"))
    implementation(project(":modules:auth"))
    implementation(project(":modules:stock"))

    // Spring WebとThymeleafテンプレートエンジン
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    // KotlinとJacksonの連携を強化します。
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // 開発用のH2データベース
    runtimeOnly("com.h2database:h2")

    // テスト用の依存関係
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// このモジュールを起動可能なアプリケーションとして設定します。
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = true
}

// このモジュールは実行可能なJARを生成するため、他のモジュールからはライブラリとして参照されません。
// そのため、通常のjarタスクは無効化します。
tasks.getByName<Jar>("jar") {
    enabled = false
}