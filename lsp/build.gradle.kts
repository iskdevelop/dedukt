plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    application
}

application {
    mainClass.set("io.dedukt.lsp.DeduKtLanguageServerKt")
}

dependencies {
    implementation(project(BuildConfig.Modules.CORE))
    implementation(project(BuildConfig.Modules.DSL))
    implementation(libs.bundles.kotlin.common)
    implementation(libs.lsp4j)

    testImplementation(libs.bundles.testing)
    testImplementation(libs.mockk)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}