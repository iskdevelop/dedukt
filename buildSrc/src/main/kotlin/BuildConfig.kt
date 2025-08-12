object BuildConfig {
    const val GROUP = "com.iskportal.dedukt"
    const val VERSION = "0.1.0-SNAPSHOT"

    const val JVM_TARGET = "17"
    const val KOTLIN_VERSION = "1.9.20"

    object Modules {
        const val CORE = ":core"
        const val DSL = ":dsl"
        const val LSP = ":lsp"
        const val NOTEBOOK = ":notebook"
        const val DOCS = ":docs"
    }
}