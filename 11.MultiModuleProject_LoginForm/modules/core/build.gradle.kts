plugins {
    id("org.jetbrains.kotlin.jvm")
}

// coreモジュールは、プロジェクト全体で共有される共通のクラスやユーティリティを配置します。
// この段階では特定のフレームワークに依存しない、純粋なKotlinライブラリとして設定します。
dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}