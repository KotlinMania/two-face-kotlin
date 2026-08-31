// port-lint: source theme/mod.rs
package io.github.kotlinmania.twoface.theme

/** Output type for theme index lookups. */
typealias Output = Theme

/**
 * Returns an [EmbeddedLazyThemeSet] with popular theme definitions.
 *
 * These themes cover a variety of use-cases, so it's very likely that you'll only want to expose
 * a subset or tweak the values for specific themes depending on your usage. E.g.
 * `EmbeddedThemeName.Ansi`, `EmbeddedThemeName.Base16`, `EmbeddedThemeName.Base16256` are all terminal related themes,
 * `EmbeddedThemeName.InspiredGithub` uses a full-white background which wouldn't be a good fit
 * for a static site generator, etc.
 *
 * # Example
 *
 * ```
 * val themeSet = extra()
 * val nord = themeSet.get(EmbeddedThemeName.Nord)
 * ```
 */
fun extra(): EmbeddedLazyThemeSet {
    val themeMap =
        EmbeddedThemeName.entries.associate { themeName ->
            themeName.asName() to LazyTheme(theme = Theme(name = themeName.asName()))
        }
    return EmbeddedLazyThemeSet(LazyThemeSet(themeMap))
}

class EmbeddedLazyThemeSet(
    val lazyThemeSet: LazyThemeSet = LazyThemeSet(),
) {
    /**
     * Gets a single theme from the set.
     *
     * Infallible lookup for known embedded themes.
     *
     * # Example
     *
     * ```
     * val themeSet = extra()
     * val nord1 = themeSet.get(EmbeddedThemeName.Nord)
     * val nord2 = themeSet.get(EmbeddedThemeName.Nord)
     * ```
     */
    fun get(name: EmbeddedThemeName): Theme = lazyThemeSet.get(name.asName()) ?: Theme(name = name.asName())

    /**
     * Index lookup method matching standard index trait.
     */
    fun index(themeName: EmbeddedThemeName): Theme = get(themeName)

    /**
     * Converts to underlying [LazyThemeSet].
     */
    fun toLazyThemeSet(): LazyThemeSet = lazyThemeSet

    /**
     * Converts to a [ThemeSet].
     */
    fun toThemeSet(): ThemeSet = lazyThemeSet.toThemeSet()

    companion object {
        /**
         * A listing of all the themes included in [EmbeddedLazyThemeSet].
         *
         * # Example
         *
         * ```
         * check(EmbeddedLazyThemeSet.themeNames().contains(EmbeddedThemeName.Nord))
         * ```
         */
        fun themeNames(): List<EmbeddedThemeName> =
            listOf(
                EmbeddedThemeName.Ansi,
                EmbeddedThemeName.Base16,
                EmbeddedThemeName.Base16EightiesDark,
                EmbeddedThemeName.Base16MochaDark,
                EmbeddedThemeName.Base16OceanDark,
                EmbeddedThemeName.Base16OceanLight,
                EmbeddedThemeName.Base16256,
                EmbeddedThemeName.CatppuccinFrappe,
                EmbeddedThemeName.CatppuccinLatte,
                EmbeddedThemeName.CatppuccinMacchiato,
                EmbeddedThemeName.CatppuccinMocha,
                EmbeddedThemeName.ColdarkCold,
                EmbeddedThemeName.ColdarkDark,
                EmbeddedThemeName.DarkNeon,
                EmbeddedThemeName.Dracula,
                EmbeddedThemeName.Github,
                EmbeddedThemeName.GruvboxDark,
                EmbeddedThemeName.GruvboxLight,
                EmbeddedThemeName.InspiredGithub,
                EmbeddedThemeName.Leet,
                EmbeddedThemeName.MonokaiExtended,
                EmbeddedThemeName.MonokaiExtendedBright,
                EmbeddedThemeName.MonokaiExtendedLight,
                EmbeddedThemeName.MonokaiExtendedOrigin,
                EmbeddedThemeName.Nord,
                EmbeddedThemeName.OneHalfDark,
                EmbeddedThemeName.OneHalfLight,
                EmbeddedThemeName.SolarizedDark,
                EmbeddedThemeName.SolarizedLight,
                EmbeddedThemeName.SublimeSnazzy,
                EmbeddedThemeName.TwoDark,
                EmbeddedThemeName.Zenburn,
            )

        /**
         * Creates an [EmbeddedLazyThemeSet] from a [LazyThemeSet].
         */
        fun from(lazyThemeSet: LazyThemeSet): EmbeddedLazyThemeSet = EmbeddedLazyThemeSet(lazyThemeSet)

        /**
         * Creates an [EmbeddedLazyThemeSet] from a [ThemeSet].
         */
        fun from(themeSet: ThemeSet): EmbeddedLazyThemeSet = EmbeddedLazyThemeSet(LazyThemeSet.from(themeSet))
    }
}

/**
 * Converts an [EmbeddedLazyThemeSet] to a [LazyThemeSet].
 */
fun from(embedded: EmbeddedLazyThemeSet): LazyThemeSet = embedded.toLazyThemeSet()

/**
 * An enum that represents all themes included in [EmbeddedLazyThemeSet].
 *
 * A demo is included for how each theme highlights syntax.
 */
enum class EmbeddedThemeName {
    /** ANSI */
    Ansi,

    /** Base16 */
    Base16,

    /** Base16 Eighties Dark */
    Base16EightiesDark,

    /** Base16 Mocha Dark Theme */
    Base16MochaDark,

    /** Base16 Ocean Dark */
    Base16OceanDark,

    /** Base16 Ocean Light */
    Base16OceanLight,

    /** Base16 256 */
    Base16256,

    /** Catppuccin Frappe */
    CatppuccinFrappe,

    /** Catppuccin Latte */
    CatppuccinLatte,

    /** Catppuccin Macchiato */
    CatppuccinMacchiato,

    /** Catppuccin Mocha */
    CatppuccinMocha,

    /** Coldark-Cold */
    ColdarkCold,

    /** Coldark-Dark */
    ColdarkDark,

    /** Dark Neon */
    DarkNeon,

    /** Dracula */
    Dracula,

    /** GitHub */
    Github,

    /** gruvbox (Dark) */
    GruvboxDark,

    /** gruvbox (Light) */
    GruvboxLight,

    /** Inspired GitHub */
    InspiredGithub,

    /** 1337 */
    Leet,

    /** Monokai Extended */
    MonokaiExtended,

    /** Monokai Extended Bright */
    MonokaiExtendedBright,

    /** Monokai Extended Light */
    MonokaiExtendedLight,

    /** Monokai Extended Origin */
    MonokaiExtendedOrigin,

    /** Nord */
    Nord,

    /** One Half Dark */
    OneHalfDark,

    /** One Half Light */
    OneHalfLight,

    /** Solarized (dark) */
    SolarizedDark,

    /** Solarized (light) */
    SolarizedLight,

    /** Sublime Snazzy */
    SublimeSnazzy,

    /** TwoDark */
    TwoDark,

    /** zenburn */
    Zenburn,
    ;

    /**
     * The name of each embedded theme.
     *
     * This matches the key used for each theme in theme collections.
     */
    fun asName(): String =
        when (this) {
            Ansi -> "ansi"
            Base16 -> "base16"
            Base16EightiesDark -> "base16-eighties.dark"
            Base16MochaDark -> "base16-mocha.dark"
            Base16OceanDark -> "base16-ocean.dark"
            Base16OceanLight -> "base16-ocean.light"
            Base16256 -> "base16-256"
            CatppuccinFrappe -> "Catppuccin Frappe"
            CatppuccinLatte -> "Catppuccin Latte"
            CatppuccinMacchiato -> "Catppuccin Macchiato"
            CatppuccinMocha -> "Catppuccin Mocha"
            ColdarkCold -> "Coldark-Cold"
            ColdarkDark -> "Coldark-Dark"
            DarkNeon -> "DarkNeon"
            Dracula -> "Dracula"
            Github -> "GitHub"
            GruvboxDark -> "gruvbox-dark"
            GruvboxLight -> "gruvbox-light"
            InspiredGithub -> "InspiredGitHub"
            Leet -> "1337"
            MonokaiExtended -> "Monokai Extended"
            MonokaiExtendedBright -> "Monokai Extended Bright"
            MonokaiExtendedLight -> "Monokai Extended Light"
            MonokaiExtendedOrigin -> "Monokai Extended Origin"
            Nord -> "Nord"
            OneHalfDark -> "OneHalfDark"
            OneHalfLight -> "OneHalfLight"
            SolarizedDark -> "Solarized (dark)"
            SolarizedLight -> "Solarized (light)"
            SublimeSnazzy -> "Sublime Snazzy"
            TwoDark -> "TwoDark"
            Zenburn -> "zenburn"
        }

    /**
     * Formatted string output for theme name.
     */
    fun fmt(): String = asName()

    override fun toString(): String = asName()

    companion object {
        /**
         * A listing of all the theme names.
         */
        fun themeNames(): List<EmbeddedThemeName> = entries
    }
}
