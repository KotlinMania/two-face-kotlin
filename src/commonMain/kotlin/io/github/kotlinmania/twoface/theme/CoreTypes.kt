// port-lint: source theme/core_types.rs
package io.github.kotlinmania.twoface.theme

/**
 * Representation of a syntax highlighting theme.
 */
data class Theme(
    val name: String? = null,
    val author: String? = null,
)

/**
 * A collection of named themes.
 */
data class ThemeSet(
    val themes: Map<String, Theme> = emptyMap(),
)

/**
 * Lazy theme container holding serialized theme data.
 */
class LazyTheme(
    internal val serialized: ByteArray = byteArrayOf(),
    private val theme: Theme = Theme(),
) {
    fun deserialize(): Theme = theme

    fun get(): Theme = deserialize()
}

/**
 * A [ThemeSet] that lazily deserializes/decompresses a single theme at a time.
 *
 * This pattern is already actually used by syntect SyntaxSet which
 * deserializes/decompresses syntaxes on demand. Doing this has the benefit of lowering load times
 * when you're only using a few themes at the expense of slightly larger embedded size due to
 * worse compression.
 *
 * # Example
 *
 * For convenience you can easily convert between a [LazyThemeSet] and a [ThemeSet].
 *
 * ```
 * val themeSet: LazyThemeSet = extra().into()
 * val syntectThemeSet: ThemeSet = themeSet.toThemeSet()
 * ```
 */
class LazyThemeSet(
    internal val themes: Map<String, LazyTheme> = emptyMap(),
) {
    /**
     * Access a single theme from the set.
     *
     * Calling this multiple times for the same theme will only deserialize and decompress the
     * theme once.
     *
     * # Example
     *
     * ```
     * val themeSet = LazyThemeSet.from(extra())
     * val nord1 = themeSet.get("Nord")
     * val nord2 = themeSet.get("Nord")
     * ```
     */
    fun get(name: String): Theme? = themes[name]?.get()

    /**
     * Iterate over all the theme names included in the set.
     *
     * # Example
     *
     * ```
     * val themeSet = LazyThemeSet.from(extra())
     * check(themeSet.themeNames().any { it == "Nord" })
     * ```
     */
    fun themeNames(): Sequence<String> = themes.keys.asSequence()

    /**
     * Convert this lazy theme set into a [ThemeSet].
     */
    fun toThemeSet(): ThemeSet =
        ThemeSet(themes = themes.mapValues { it.value.get() })

    companion object {
        /**
         * Create a [LazyThemeSet] from a [ThemeSet].
         */
        fun from(fullThemes: ThemeSet): LazyThemeSet =
            LazyThemeSet(
                themes = fullThemes.themes.mapValues { (_, theme) -> LazyTheme(theme = theme) },
            )
    }
}
