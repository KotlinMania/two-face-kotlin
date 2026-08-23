// port-lint: tests syntax.rs
package io.github.kotlinmania.twoface.syntax

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class SyntaxTest {
    @Test
    fun testExtraNoNewlines() {
        val synSet = extraNoNewlines()
        val toml = synSet.findSyntaxByName("TOML")
        val typeScript = synSet.findSyntaxByName("TypeScript")
        val dockerfile = synSet.findSyntaxByName("Dockerfile")

        assertNotNull(toml)
        assertEquals("TOML", toml.name)
        assertNotNull(typeScript)
        assertEquals("TypeScript", typeScript.name)
        assertNotNull(dockerfile)
        assertEquals("Dockerfile", dockerfile.name)
    }

    @Test
    fun testExtraNewlines() {
        val synSet = extraNewlines()
        val toml = synSet.findSyntaxByExtension("toml")
        val ts = synSet.findSyntaxByExtension("ts")

        assertNotNull(toml)
        assertEquals("TOML", toml.name)
        assertNotNull(ts)
        assertEquals("TypeScript", ts.name)
    }
}
