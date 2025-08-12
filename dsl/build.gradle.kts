plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = BuildConfig.JVM_TARGET
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    js(IR) {
        browser()
        nodejs()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(BuildConfig.Modules.CORE))
                implementation(libs.bundles.kotlin.common)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test")) // multiplatform test lib only
                // Removed libs.bundles.testing to avoid JVM-only libs leaking to JS
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(libs.bundles.testing) // JVM-only test libs (JUnit)
            }
        }
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js")) // JS-compatible test framework
            }
        }
    }
}
