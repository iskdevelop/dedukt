package com.iskportal.dedukt.dsl.ast

/**
 * Abstract Syntax Tree nodes for DeduKt expressions.
 */
sealed class AstNode {
    data class Placeholder(val content: String) : AstNode()
    // More node types will be added here
}