plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("io.ktor.plugin")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = BuildConfig.JVM_TARGET
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
        withJava()
    }

    js(IR) {
        browser {
            binaries.executable()
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(BuildConfig.Modules.CORE))
                implementation(project(BuildConfig.Modules.DSL))
                implementation(libs.bundles.kotlin.common)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.bundles.testing)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.bundles.ktor.server)
            }
        }
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
    }
}

application {
    mainClass.set("com.iskportal.dedukt.notebook.NotebookServerKt")
}