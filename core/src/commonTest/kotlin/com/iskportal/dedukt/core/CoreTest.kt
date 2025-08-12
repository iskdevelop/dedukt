package com.iskportal.dedukt.core

import kotlin.test.Test
import kotlin.test.assertEquals

class CoreTest {
    @Test
    fun testVersion() {
        assertEquals("0.1.0-SNAPSHOT", Core.VERSION)
    }

    @Test
    fun testInitialization() {
        // Placeholder test
        Core.initialize()
        Core.shutdown()
    }
}