package com.iskportal.dedukt.kernel.expression

sealed interface Expression {
    fun eval(): Expression
}