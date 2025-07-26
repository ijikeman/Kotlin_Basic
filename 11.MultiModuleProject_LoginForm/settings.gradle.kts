pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "11.MultiModuleProject_LoginForm"

include("modules:core", "modules:auth", "modules:stock", "modules:web")