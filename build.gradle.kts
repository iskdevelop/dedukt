plugins {
    kotlin("jvm") version "2.0.20" apply false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        google()
    }

}

