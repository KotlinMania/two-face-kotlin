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
 * val themeSet: LazyThemeSet = LazyThemeSet.from(extra())
 * val syntectThemeSet: ThemeSet = ThemeSet.from(themeSet)
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
    fun get(name: String): Theme? {
        val lazyTheme = themes[name] ?: return null
        return lazyTheme.deserialize()
    }

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
    fun toThemeSet(): ThemeSet = from(this)

    companion object {
        /**
         * Create a [LazyThemeSet] from a [ThemeSet].
         */
        fun from(fullThemes: ThemeSet): LazyThemeSet =
            LazyThemeSet(
                themes = fullThemes.themes.mapValues { (_, theme) -> from(theme) },
            )
    }
}

/**
 * Lazy theme container holding serialized theme data.
 */
class LazyTheme(
    internal val serialized: ByteArray = byteArrayOf(),
    private val theme: Theme = Theme(),
) {
    /**
     * Deserializes the underlying theme.
     */
    fun deserialize(): Theme = theme

    /**
     * Access the deserialized theme.
     */
    fun get(): Theme = deserialize()
}

/**
 * Converts a [ThemeSet] to a [LazyThemeSet].
 */
fun from(fullThemes: ThemeSet): LazyThemeSet {
    val themes = fullThemes.themes.mapValues { (_, theme) -> from(theme) }
    return LazyThemeSet(themes)
}

/**
 * Converts a [LazyThemeSet] to a [ThemeSet].
 */
fun from(lazyThemes: LazyThemeSet): ThemeSet {
    val themes = lazyThemes.themes.mapValues { (_, lazy) -> from(lazy) }
    return ThemeSet(themes)
}

/**
 * Converts a [LazyTheme] to a [Theme].
 */
fun from(lazy: LazyTheme): Theme = lazy.deserialize()

/**
 * Converts a [Theme] to a [LazyTheme].
 */
fun from(theme: Theme): LazyTheme = LazyTheme(serialized = byteArrayOf(), theme = theme)
