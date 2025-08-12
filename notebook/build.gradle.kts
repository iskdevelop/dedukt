plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("io.ktor.plugin")
    application
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
                implementation(project(BuildConfig.Modules.CORE))
                implementation(project(BuildConfig.Modules.DSL))
                implementation(libs.bundles.kotlin.common)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test")) // Multiplatform test lib only
                // Removed libs.bundles.testing here to avoid JVM-only dependencies leaking into JS
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.bundles.ktor.server)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.bundles.testing) // Put JVM-only testing libs here (JUnit, etc.)
            }
        }
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js")) // JS-compatible testing framework
            }
        }
    }
}

application {
    mainClass.set("com.iskportal.dedukt.notebook.NotebookServerKt")
}

repositories {
    mavenCentral()
    // add other repos as needed
}
