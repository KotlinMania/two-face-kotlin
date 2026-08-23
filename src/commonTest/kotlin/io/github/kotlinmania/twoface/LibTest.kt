// port-lint: tests src/lib.rs
package io.github.kotlinmania.twoface

import kotlin.test.Test
import kotlin.test.assertEquals

class LibTest {
    @Test
    fun testVersion() {
        assertEquals("0.5.1", TwoFace.VERSION)
    }
}
