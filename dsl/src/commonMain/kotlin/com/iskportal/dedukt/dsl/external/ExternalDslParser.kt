package com.iskportal.dedukt.dsl.external

import com.iskportal.dedukt.dsl.ast.AstNode

/**
 * Parser for external DeduKt DSL syntax.
 * This will parse the standalone DSL language into AST nodes.
 */
class ExternalDslParser {
    fun parse(source: String): AstNode {
        // Placeholder implementation
        return AstNode.Placeholder(source)
    }

    fun validate(source: String): List<ParseError> {
        // Placeholder implementation
        return emptyList()
    }
}

data class ParseError(
    val message: String,
    val line: Int,
    val column: Int,
    val severity: Severity = Severity.ERROR
) {
    enum class Severity { ERROR, WARNING, INFO }
}
