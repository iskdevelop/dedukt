package com.iskportal.dedukt.lsp.structures

typealias PositiveInt = Int

fun PositiveInt.correct(): Int {
    return if (this < 0) {
        -this
    } else {
        this
    }
}

fun PositiveInt.assertCorrect(): Boolean {
    return this >= 0
}