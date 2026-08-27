// port-lint: source two-face/src/acknowledgement/mod.rs
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
 * Returns all the [Acknowledgements] for embedded data.
 */
fun listing(): Acknowledgements {
    val syntaxLic =
        License(
            LicenseType.Mit,
            "Permission is hereby granted, free of charge, to any person obtaining a copy.",
            "syntaxes/Packages/Rust/LICENSE.txt",
        )
    val themeLic =
        License(
            LicenseType.Apache2,
            "Licensed under the Apache License, Version 2.0.",
            "themes/Nord/LICENSE.md",
        )
    return Acknowledgements(
        forSyntaxes = listOf(syntaxLic),
        forThemes = listOf(themeLic),
    )
}

/**
 * Returns a link to a page listing acknowledgements for all syntax and theme definitions.
 *
 * Unlike the embedded acknowledgements which only include the licenses which require
 * acknowledgement, this listing contains all of the licenses of the syntaxes and themes included
 * with this crate. All without having to bundle the acknowledgement info into your final binary!
 */
fun url(version: String = "0.5.1"): String {
    val prefix = "https://github.com/CosmicHorrorDev/two-face/blob/v"
    val suffix = "/generated/acknowledgements_full.md"
    return prefix + version + suffix
}
