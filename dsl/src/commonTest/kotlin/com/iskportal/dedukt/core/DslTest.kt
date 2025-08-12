package com.iskportal.dedukt.dsl

import kotlin.test.Test
import kotlin.test.assertNotNull

class DslTest {
    @Test
    fun testBasicDsl() {
        var result: Expression? = null
        dedukt {
            result = expression {
                symbol("x")
            }
        }
        assertNotNull(result)
    }
}