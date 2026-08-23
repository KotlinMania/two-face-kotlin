// port-lint: source src/theme/mod.rs
package io.github.kotlinmania.twoface.theme

/**
 * An enum that represents all themes included in the embedded theme set.
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
    Base16_256,

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
            Base16_256 -> "base16-256"
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

    override fun toString(): String = asName()

    companion object {
        /**
         * A listing of all the theme names.
         */
        fun themeNames(): List<EmbeddedThemeName> = entries
    }
}
