plugins {
    id("org.jetbrains.dokka")
}

dependencies {
    dokkaPlugin("org.jetbrains.dokka:dokka-base:1.9.10")
}

tasks.dokkaHtml.configure {
    moduleName.set("DeduKt API Documentation")

    dokkaSourceSets {
        configureEach {
            includes.from("module.md")
            sourceLink {
                localDirectory.set(rootDir)
                remoteUrl.set(java.net.URL("https://github.com/iskdevelop/dedukt/tree/main"))
                remoteLineSuffix.set("#L")
            }
        }
    }
}

tasks.register<Exec>("mkdocsBuild") {
    group = "documentation"
    description = "Build documentation with MkDocs"
    workingDir = file(".")
    commandLine = listOf("mkdocs", "build")
}

tasks.register<Exec>("mkdocsServe") {
    group = "documentation"
    description = "Serve documentation with MkDocs"
    workingDir = file(".")
    commandLine = listOf("mkdocs", "serve")
}