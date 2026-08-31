// port-lint: tests two-face/src/theme/mod.rs
package io.github.kotlinmania.twoface.theme

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
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
    }

    @Test
    fun themeSetRoundtrip() {
        val embedded = extra()
        val themeSet: ThemeSet = embedded.toThemeSet()
        val lazy: LazyThemeSet = LazyThemeSet.from(themeSet)
        val themeSetAgain: ThemeSet = lazy.toThemeSet()

        assertEquals(themeSet.themes.keys, themeSetAgain.themes.keys)
        for (key in themeSet.themes.keys) {
            assertEquals(themeSet.themes[key], themeSetAgain.themes[key])
        }
    }

    @Test
    fun embeddedThemeIsExhaustive() {
        val themeSet = extra()
        for (themeName in EmbeddedThemeName.entries) {
            val theme = themeSet.get(themeName)
            assertNotNull(theme)
            assertEquals(themeName.asName(), theme.name)
        }

        assertEquals(EmbeddedThemeName.entries.size, themeSet.lazyThemeSet.themes.size)
        assertEquals(EmbeddedThemeName.entries.size, EmbeddedLazyThemeSet.themeNames().size)

        val allUnique = EmbeddedLazyThemeSet.themeNames().toSet()
        assertEquals(EmbeddedLazyThemeSet.themeNames().size, allUnique.size)
    }
}
