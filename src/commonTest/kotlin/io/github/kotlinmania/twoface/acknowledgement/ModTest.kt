// port-lint: tests src/acknowledgement/mod.rs
package io.github.kotlinmania.twoface.acknowledgement

import kotlin.test.Test
import kotlin.test.assertEquals

class ModTest {
    @Test
    fun testUrl() {
        assertEquals(
            "https://github.com/CosmicHorrorDev/two-face/blob/v0.5.1/generated/acknowledgements_full.md",
            url("0.5.1"),
        )
    }

    @Test
    fun testForSyntaxesAndThemes() {
        val syntaxLic = License(LicenseType.Mit, "syntax", "syntax/LICENSE")
        val themeLic = License(LicenseType.Apache2, "theme", "theme/LICENSE")
        val ack =
            Acknowledgements(
                forSyntaxes = listOf(syntaxLic),
                forThemes = listOf(themeLic),
            )

        assertEquals(listOf(syntaxLic), ack.forSyntaxes())
        assertEquals(listOf(themeLic), ack.forThemes())
    }
}
