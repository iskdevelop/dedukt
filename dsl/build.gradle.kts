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
                implementation(libs.bundles.testing)
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
    }
}