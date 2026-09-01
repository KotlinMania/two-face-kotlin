// port-lint: tests syntax.rs
package io.github.kotlinmania.twoface.syntax

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class SyntaxTest {
    @Test
    fun testExtraNoNewlines() {
        val synSet = extraNoNewlines()
        val toml = synSet.findSyntaxByName("TOML")
        val typeScript = synSet.findSyntaxByName("TypeScript")
        val dockerfile = synSet.findSyntaxByName("Dockerfile")
        val kotlin = synSet.findSyntaxByName("kotlin")
        val rust = synSet.findSyntaxByName("rust")
        val json = synSet.findSyntaxByName("JSON")
        val yaml = synSet.findSyntaxByName("YAML")
        val markdown = synSet.findSyntaxByName("Markdown")

        assertNotNull(toml)
        assertEquals("TOML", toml.name)
        assertNotNull(typeScript)
        assertEquals("TypeScript", typeScript.name)
        assertNotNull(dockerfile)
        assertEquals("Dockerfile", dockerfile.name)
        assertNotNull(kotlin)
        assertEquals("Kotlin", kotlin.name)
        assertNotNull(rust)
        assertEquals("Rust", rust.name)
        assertNotNull(json)
        assertEquals("JSON", json.name)
        assertNotNull(yaml)
        assertEquals("YAML", yaml.name)
        assertNotNull(markdown)
        assertEquals("Markdown", markdown.name)
    }

    @Test
    fun testExtraNewlines() {
        val synSet = extraNewlines()
        val toml = synSet.findSyntaxByExtension("toml")
        val ts = synSet.findSyntaxByExtension("ts")
        val tsx = synSet.findSyntaxByExtension("tsx")
        val kt = synSet.findSyntaxByExtension("kt")
        val kts = synSet.findSyntaxByExtension("kts")
        val rs = synSet.findSyntaxByExtension("rs")
        val md = synSet.findSyntaxByExtension("md")
        val unknown = synSet.findSyntaxByExtension("unknownext")

        assertNotNull(toml)
        assertEquals("TOML", toml.name)
        assertNotNull(ts)
        assertEquals("TypeScript", ts.name)
        assertNotNull(tsx)
        assertEquals("TypeScript", tsx.name)
        assertNotNull(kt)
        assertEquals("Kotlin", kt.name)
        assertNotNull(kts)
        assertEquals("Kotlin", kts.name)
        assertNotNull(rs)
        assertEquals("Rust", rs.name)
        assertNotNull(md)
        assertEquals("Markdown", md.name)
        assertNull(unknown)
    }
}
