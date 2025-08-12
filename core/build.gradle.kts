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
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
        nodejs()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.bundles.kotlin.common)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))  // Kotlin common test framework, multiplatform compatible
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(libs.bundles.testing)  // junit-jupiter or junit 4 here
            }
        }
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))  // JS-compatible test lib
            }
        }
    }

}