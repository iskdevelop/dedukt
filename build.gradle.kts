plugins {
    kotlin("multiplatform") version "1.9.20" apply false
    kotlin("jvm") version "1.9.20" apply false
    kotlin("js") version "1.9.20" apply false
    kotlin("plugin.serialization") version "1.9.20" apply false
    id("org.jetbrains.dokka") version "1.9.10" apply false
    id("io.ktor.plugin") version "2.3.7" apply false
}

allprojects {
    group = "com.iskportal.dedukt"
    version = "0.1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

tasks.register("buildAll") {
    dependsOn(subprojects.map { "${it.path}:build" })
}

tasks.register("testAll") {
    dependsOn(subprojects.map { "${it.path}:test" })
}

tasks.register("cleanAll") {
    dependsOn(subprojects.map { "${it.path}:clean" })
}