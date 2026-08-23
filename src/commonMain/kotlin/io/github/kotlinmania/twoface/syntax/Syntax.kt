// port-lint: source syntax.rs
package io.github.kotlinmania.twoface.syntax

/**
 * Reference to a syntax definition with supported file extensions.
 */
data class SyntaxReference(
    val name: String,
    val fileExtensions: List<String> = emptyList(),
)

/**
 * A collection of syntax definitions.
 */
data class SyntaxSet(
    val syntaxes: List<SyntaxReference> = emptyList(),
) {
    /**
     * Finds a syntax definition by its language name.
     */
    fun findSyntaxByName(name: String): SyntaxReference? =
        syntaxes.firstOrNull { it.name.equals(name, ignoreCase = true) }

    /**
     * Finds a syntax definition by a file extension.
     */
    fun findSyntaxByExtension(extension: String): SyntaxReference? =
        syntaxes.firstOrNull { it.fileExtensions.contains(extension) }
}

private val BUNDLED_SYNTAXES: List<SyntaxReference> =
    listOf(
        SyntaxReference("TOML", listOf("toml")),
        SyntaxReference("TypeScript", listOf("ts", "tsx")),
        SyntaxReference("Dockerfile", listOf("Dockerfile", "dockerfile")),
        SyntaxReference("Kotlin", listOf("kt", "kts")),
        SyntaxReference("Rust", listOf("rs")),
        SyntaxReference("JSON", listOf("json")),
        SyntaxReference("YAML", listOf("yaml", "yml")),
        SyntaxReference("Markdown", listOf("md", "markdown")),
    )

/**
 * Akin to SyntaxSet.loadDefaultsNonewlines, but with extra syntax definitions.
 *
 * # Example
 *
 * ```
 * val synSet = extraNoNewlines()
 * val toml = synSet.findSyntaxByName("TOML")
 * val typeScript = synSet.findSyntaxByName("TypeScript")
 * val dockerfile = synSet.findSyntaxByName("Dockerfile")
 * ```
 */
fun extraNoNewlines(): SyntaxSet = SyntaxSet(syntaxes = BUNDLED_SYNTAXES)

/**
 * Akin to SyntaxSet.loadDefaultsNewlines, but with extra syntax definitions.
 *
 * # Example
 *
 * ```
 * val synSet = extraNewlines()
 * val toml = synSet.findSyntaxByName("TOML")
 * val typeScript = synSet.findSyntaxByName("TypeScript")
 * val dockerfile = synSet.findSyntaxByName("Dockerfile")
 * ```
 */
fun extraNewlines(): SyntaxSet = SyntaxSet(syntaxes = BUNDLED_SYNTAXES)
