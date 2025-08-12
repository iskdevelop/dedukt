rootProject.name = "dedukt"

include(
    ":core",
    ":dsl",
    ":lsp",
    ":notebook",
    ":docs"
)

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
    versionCatalogs {
        create("libs") {
            // Kotlin
            library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib").version("1.9.20")
            library("kotlin-test", "org.jetbrains.kotlin", "kotlin-test").version("1.9.20")
            library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").version("1.7.3")
            library("kotlinx-serialization-json", "org.jetbrains.kotlinx", "kotlinx-serialization-json").version("1.6.0")

            // Ktor
            library("ktor-server-core", "io.ktor", "ktor-server-core").version("2.3.7")
            library("ktor-server-netty", "io.ktor", "ktor-server-netty").version("2.3.7")
            library("ktor-server-websockets", "io.ktor", "ktor-server-websockets").version("2.3.7")
            library("ktor-serialization-kotlinx-json", "io.ktor", "ktor-serialization-kotlinx-json").version("2.3.7")

            // LSP
            library("lsp4j", "org.eclipse.lsp4j", "org.eclipse.lsp4j").version("0.21.1")

            // Testing
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").version("5.10.1")
            library("kotest-framework-engine", "io.kotest", "kotest-framework-engine").version("5.8.0")
            library("mockk", "io.mockk", "mockk").version("1.13.8")

            // Build
            bundle("kotlin-common", listOf("kotlin-stdlib", "kotlinx-coroutines-core", "kotlinx-serialization-json"))
            bundle("ktor-server", listOf("ktor-server-core", "ktor-server-netty", "ktor-server-websockets", "ktor-serialization-kotlinx-json"))
            bundle("testing", listOf("kotlin-test", "junit-jupiter", "kotest-framework-engine"))
        }
    }
}