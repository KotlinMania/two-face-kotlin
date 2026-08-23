// port-lint: tests src/theme/mod.rs
package io.github.kotlinmania.twoface.theme

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ModTest {
    @Test
    fun testEmbeddedThemeNames() {
        assertEquals("1337", EmbeddedThemeName.Leet.asName())
        assertEquals("Solarized (dark)", EmbeddedThemeName.SolarizedDark.asName())
        assertEquals("Solarized (dark)", EmbeddedThemeName.SolarizedDark.toString())
        assertEquals("Nord", EmbeddedThemeName.Nord.asName())
        assertEquals("zenburn", EmbeddedThemeName.Zenburn.asName())
        assertEquals("Catppuccin Mocha", EmbeddedThemeName.CatppuccinMocha.asName())

        val names = EmbeddedThemeName.themeNames()
        assertEquals(32, names.size)
        assertTrue(names.contains(EmbeddedThemeName.Nord))
        assertTrue(names.contains(EmbeddedThemeName.Dracula))
        assertTrue(names.contains(EmbeddedThemeName.Github))

        val uniqueNames = names.map { it.asName() }.toSet()
        assertEquals(32, uniqueNames.size)
    }
}
