// port-lint: tests two-face/src/lib.rs
package io.github.kotlinmania.twoface

import io.github.kotlinmania.twoface.acknowledgement.listing
import io.github.kotlinmania.twoface.syntax.extraNewlines
import io.github.kotlinmania.twoface.syntax.extraNoNewlines
import io.github.kotlinmania.twoface.theme.extra
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class LibTest {
    @Test
    fun testVersion() {
        assertEquals("0.5.1", TwoFace.VERSION)
    }

    @Test
    fun sanity() {
        assertNotNull(listing())
        assertNotNull(extraNewlines())
        assertNotNull(extraNoNewlines())
        assertNotNull(extra())
    }
}
