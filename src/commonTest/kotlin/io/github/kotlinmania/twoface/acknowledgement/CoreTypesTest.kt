// port-lint: source src/acknowledgement/core_types.rs
package io.github.kotlinmania.twoface.acknowledgement

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LicenseTypeNeedsAcknowledgementTest {
    @Test
    fun mitNeedsAcknowledgement() {
        assertTrue(LicenseType.Mit.needsAcknowledgement())
    }

    @Test
    fun wtfplDoesNotNeedAcknowledgement() {
        assertFalse(LicenseType.Wtfpl.needsAcknowledgement())
    }

    @Test
    fun acknowledgementRequiredCoversAttributionLicenses() {
        for (ty in listOf(
            LicenseType.Mit,
            LicenseType.Bsd2Clause,
            LicenseType.Bsd2ClauseFreeBsd,
            LicenseType.Bsd3Clause,
            LicenseType.Apache2,
        )) {
            assertTrue(ty.needsAcknowledgement(), "expected $ty to need acknowledgement")
        }
        for (ty in listOf(LicenseType.Sublime, LicenseType.Unlicense, LicenseType.Wtfpl)) {
            assertFalse(ty.needsAcknowledgement(), "expected $ty to not need acknowledgement")
        }
    }

    @Test
    fun licenseDelegatesNeedsAcknowledgementToType() {
        val mitLicense = License(LicenseType.Mit, "license text", "path/to/LICENSE")
        val wtfplLicense = License(LicenseType.Wtfpl, "license text", "other/LICENSE")
        assertTrue(mitLicense.needsAcknowledgement())
        assertFalse(wtfplLicense.needsAcknowledgement())
    }
}

class LicenseWriteMdTest {
    @Test
    fun writesDetailsBlockWithRelPathAndText() {
        val license = License(LicenseType.Mit, "Permission text here.", "syntaxes/Rust/LICENSE.txt")
        val md = StringBuilder()
        license.writeMd(md)
        val expected =
            "<details>\n" +
                "<summary>syntaxes/Rust/LICENSE.txt</summary>\n\n" +
                "````text\n" +
                "Permission text here.\n" +
                "````\n" +
                "</details>\n\n"
        assertEquals(expected, md.toString())
    }

    @Test
    fun appendsTrailingNewlinesWhenTextDoesNotEndWithOne() {
        val license = License(LicenseType.Mit, "no newline at end", "p")
        val md = StringBuilder("prefix-")
        license.writeMd(md)
        assertTrue(md.toString().startsWith("prefix-"))
        assertTrue(md.toString().endsWith("\n\n"))
    }
}

class AcknowledgementsToMdTest {
    @Test
    fun emptyAcknowledgementsProducesOnlyBatHeader() {
        val ack = Acknowledgements(forSyntaxes = emptyList(), forThemes = emptyList())
        val md = ack.toMd()
        val expected =
            "Most of the code for generating both theme and syntax dumps along with the\n" +
                "curation of said themes and syntaxes is taken from the\n" +
                "[`bat` project](https://github.com/sharkdp/bat).\n"
        assertEquals(expected, md)
    }

    @Test
    fun syntaxesOnlyEmitsSyntaxesSectionAndNoThemes() {
        val license = License(LicenseType.Mit, "text", "syntaxes/X/LICENSE")
        val ack = Acknowledgements(forSyntaxes = listOf(license), forThemes = emptyList())
        val md = ack.toMd()
        assertTrue("# Syntaxes" in md)
        assertFalse("# Themes" in md)
        assertTrue("syntaxes/X/LICENSE" in md)
    }

    @Test
    fun themesOnlyEmitsThemesSectionAndNoSyntaxes() {
        val license = License(LicenseType.Mit, "text", "themes/X/LICENSE")
        val ack = Acknowledgements(forSyntaxes = emptyList(), forThemes = listOf(license))
        val md = ack.toMd()
        assertFalse("# Syntaxes" in md)
        assertTrue("# Themes" in md)
        assertTrue("themes/X/LICENSE" in md)
    }

    @Test
    fun bothSectionsAppearInOrderSyntaxesBeforeThemes() {
        val syntaxLicense = License(LicenseType.Mit, "s-text", "syntaxes/A/LICENSE")
        val themeLicense = License(LicenseType.Mit, "t-text", "themes/A/LICENSE")
        val ack =
            Acknowledgements(
                forSyntaxes = listOf(syntaxLicense),
                forThemes = listOf(themeLicense),
            )
        val md = ack.toMd()
        val syntaxIndex = md.indexOf("# Syntaxes")
        val themeIndex = md.indexOf("# Themes")
        assertTrue(syntaxIndex >= 0)
        assertTrue(themeIndex >= 0)
        assertTrue(syntaxIndex < themeIndex)
    }
}
