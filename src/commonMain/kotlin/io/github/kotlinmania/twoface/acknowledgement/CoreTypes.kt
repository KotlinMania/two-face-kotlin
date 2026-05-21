// port-lint: source src/acknowledgement/core_types.rs
package io.github.kotlinmania.twoface.acknowledgement

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Holds the license type, text, and relative path for a syntax or theme definition */
@Serializable
data class License(
    val ty: LicenseType,
    val text: String,
    @SerialName("rel_path") val relPath: String,
) {
    /** Appends a section for this license to `md` */
    fun writeMd(md: StringBuilder) {
        md.append("<details>\n")
        md.append("<summary>").append(relPath).append("</summary>\n\n")
        md.append("````text\n")
        md.append(text).append('\n')
        md.append("````\n")
        md.append("</details>")

        // Make sure the last char is a newline to not mess up formatting later
        if (!md.endsWith('\n')) {
            md.append('\n')
        }

        md.append('\n')
    }

    /** Whether or not this type of license requires acknowledgement */
    fun needsAcknowledgement(): Boolean = ty.needsAcknowledgement()
}

/**
 * The full range of included licenses
 *
 * Disclaimer: I am not a lawyer
 */
@Serializable
enum class LicenseType {
    /**
     * Sublime's custom license
     *
     * ```text
     * Permission to copy, use, modify, sell and distribute this
     * software is granted. This software is provided "as is" without
     * express or implied warranty, and with no claim as to its
     * suitability for any purpose.
     * ```
     */
    Sublime,

    /** [MIT License](https://choosealicense.com/licenses/mit/) */
    Mit,

    /** [BSD 2-Clause License](https://choosealicense.com/licenses/bsd-2-clause/) */
    Bsd2Clause,

    // TODO: what is the distinction here from the other BSD 2-Clause license?
    Bsd2ClauseFreeBsd,

    /** [The Unlicense](https://choosealicense.com/licenses/unlicense/) */
    Unlicense,

    /** [BSD 3-Clause License](https://choosealicense.com/licenses/bsd-3-clause/) */
    Bsd3Clause,

    /** [Apache License 2.0](https://choosealicense.com/licenses/apache-2.0/) */
    Apache2,

    /** [Do What The F*ck You Want To Public License](https://choosealicense.com/licenses/wtfpl/) */
    Wtfpl;

    /**
     * Whether or not the license requires acknowledgement
     *
     * ```
     * import io.github.kotlinmania.twoface.acknowledgement.LicenseType
     *
     * check(LicenseType.Mit.needsAcknowledgement())
     * check(!LicenseType.Wtfpl.needsAcknowledgement())
     * ```
     */
    fun needsAcknowledgement(): Boolean = when (this) {
        Mit, Bsd2Clause, Bsd2ClauseFreeBsd, Bsd3Clause, Apache2 -> true
        Sublime, Unlicense, Wtfpl -> false
    }
}

/** Holds all the license information for embedded syntaxes and themes */
@ConsistentCopyVisibility
@Serializable
data class Acknowledgements internal constructor(
    @SerialName("for_syntaxes") internal val forSyntaxes: List<License>,
    @SerialName("for_themes") internal val forThemes: List<License>,
) {
    /**
     * Display the license information as Markdown
     *
     * _Note: A full set of acknowledgements is posted for each version at the URL returned by
     * [url][io.github.kotlinmania.twoface.acknowledgement.url]_
     *
     * The output looks roughly as follows
     *
     * ```md
     * Most of the code for generating both theme and syntax dumps along with the
     * curation of said themes and syntaxes is taken from the
     * [`bat` project](https://github.com/sharkdp/bat).
     *
     * # Syntaxes
     *
     * <details>
     * <summary>syntaxes/01_Packages/Rust/LICENSE.txt</summary>
     *
     * ...Elided license text...
     * </details>
     *
     * ...
     *
     * # Themes
     *
     * <details>
     * <summary>themes/1337-Scheme/LICENSE</summary>
     *
     * ...Elided license text...
     * </details>
     * ```
     *
     * ...
     */
    fun toMd(): String {
        val md = StringBuilder(BAT_ACK)

        if (forSyntaxes.isNotEmpty()) {
            md.append("\n# Syntaxes\n\n")
            for (license in forSyntaxes) {
                license.writeMd(md)
            }
        }

        if (forThemes.isNotEmpty()) {
            md.append("# Themes\n\n")
            for (license in forThemes) {
                license.writeMd(md)
            }
        }

        return md.toString()
    }
}

private const val BAT_ACK: String =
    "Most of the code for generating both theme and syntax dumps along with the\n" +
        "curation of said themes and syntaxes is taken from the\n" +
        "[`bat` project](https://github.com/sharkdp/bat).\n"
