plugins {
    kotlin("jvm") version "2.0.20"
    application
    antlr
}

repositories {
    mavenCentral()
}
group = "com.iskportal.dedukt.kernel"
version = "0.0.1-SNAPSHOT"
dependencies {

    antlr("org.antlr:antlr4:4.+")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation(libs.junit.jupiter.engine)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "com.iskportal.dedukt.AppKt"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks {
    generateGrammarSource {
        arguments = arguments + listOf("-visitor")
    }

    compileKotlin {
        dependsOn(generateGrammarSource)
    }

    compileTestKotlin {
        dependsOn(generateTestGrammarSource)
    }

    jar {
        manifest.attributes["Main-Class"] = application.mainClass

        val dependencies = configurations
            .runtimeClasspath
            .get()
            .map { zipTree(it) }
        from(dependencies)
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}