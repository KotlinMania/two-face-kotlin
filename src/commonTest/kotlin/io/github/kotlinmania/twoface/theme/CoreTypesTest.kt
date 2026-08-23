// port-lint: tests theme/core_types.rs
package io.github.kotlinmania.twoface.theme

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class CoreTypesTest {
    @Test
    fun testLazyThemeSet() {
        val theme = Theme(name = "Nord", author = "Arctic Ice Studio")
        val themeSet = ThemeSet(themes = mapOf("Nord" to theme))
        val lazySet = LazyThemeSet.from(themeSet)

        assertEquals("Nord", lazySet.get("Nord")?.name)
        assertEquals("Arctic Ice Studio", lazySet.get("Nord")?.author)
        assertTrue(lazySet.themeNames().contains("Nord"))

        val converted = lazySet.toThemeSet()
        assertEquals(themeSet, converted)
    }

    @Test
    fun testLazyThemeDirect() {
        val lazy = LazyTheme(byteArrayOf(1, 2, 3), Theme(name = "Dracula"))
        assertEquals("Dracula", lazy.get().name)
        assertNotNull(lazy.serialized)
    }
}
