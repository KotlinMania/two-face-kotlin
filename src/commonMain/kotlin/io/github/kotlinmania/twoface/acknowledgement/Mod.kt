// port-lint: source src/acknowledgement/mod.rs
package io.github.kotlinmania.twoface.acknowledgement

/**
 * Returns all of the acknowledgements specifically for embedded syntax definitions.
 */
fun Acknowledgements.forSyntaxes(): List<License> = forSyntaxes

/**
 * Returns all of the acknowledgements specifically for embedded theme definitions.
 */
fun Acknowledgements.forThemes(): List<License> = forThemes

/**
 * Returns a link to a page listing acknowledgements for all syntax and theme definitions.
 *
 * Unlike the embedded acknowledgements which only include the licenses which require
 * acknowledgement, this listing contains all of the licenses of the syntaxes and themes included
 * with this crate. All without having to bundle the acknowledgement info into your final binary!
 */
fun url(version: String = "0.5.1"): String =
    "https://github.com/CosmicHorrorDev/two-face/blob/v$version/generated/acknowledgements_full.md"
