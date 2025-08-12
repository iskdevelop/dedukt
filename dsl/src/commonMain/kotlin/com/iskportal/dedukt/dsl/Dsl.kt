package com.iskportal.dedukt.dsl

import com.iskportal.dedukt.core.Core

/**
 * Main entry point for the DeduKt internal DSL.
 * Provides type-safe DSL for symbolic computation within Kotlin.
 */
@DslMarker
annotation class DslMarker

@DslMarker
class DslContext {
    fun expression(block: ExpressionBuilder.() -> Unit): Expression {
        return ExpressionBuilder().apply(block).build()
    }
}

class ExpressionBuilder {
    private val parts = mutableListOf<String>()

    fun symbol(name: String) {
        parts.add("symbol($name)")
    }

    fun build(): Expression {
        return Expression(parts.joinToString(" + "))
    }
}

data class Expression(val value: String) {
    override fun toString(): String = value
}

fun dedukt(block: DslContext.() -> Unit) {
    Core.initialize()
    try {
        DslContext().block()
    } finally {
        Core.shutdown()
    }
}