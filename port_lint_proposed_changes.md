# port-lint Proposed Changes

**Generated:** 2026-09-01
**Source:** tmp
**Target:** src/commonMain/kotlin/io/github/kotlinmania/twoface

These are review proposals only. They are emitted when a Rust -> Kotlin pair matches only after fallback normalization, so the existing `port-lint` header is not an exact provenance match.

| Target file | Current header | Proposed header | Source path | Reason |
|-------------|----------------|-----------------|-------------|--------|
| `src/commonMain/kotlin/io/github/kotlinmania/twoface/theme/Mod.kt` | `// port-lint: source theme/mod.rs` | `// port-lint: source theme/mod.rs` | `theme/mod.rs` | `port-lint provenance header matched only after fallback normalization: 'theme/mod.rs' vs expected 'theme/mod.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/twoface/theme/ModTest.kt` | `// port-lint: tests theme/mod.rs` | `// port-lint: tests theme/mod.rs` | `theme/mod.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:theme/mod.rs' vs expected 'theme/mod.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/twoface/theme/CoreTypes.kt` | `// port-lint: source theme/core_types.rs` | `// port-lint: source theme/core_types.rs` | `theme/core_types.rs` | `port-lint provenance header matched only after fallback normalization: 'theme/core_types.rs' vs expected 'theme/core_types.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/twoface/theme/CoreTypesTest.kt` | `// port-lint: tests theme/core_types.rs` | `// port-lint: tests theme/core_types.rs` | `theme/core_types.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:theme/core_types.rs' vs expected 'theme/core_types.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/twoface/acknowledgement/CoreTypes.kt` | `// port-lint: source acknowledgement/core_types.rs` | `// port-lint: source acknowledgement/core_types.rs` | `acknowledgement/core_types.rs` | `port-lint provenance header matched only after fallback normalization: 'acknowledgement/core_types.rs' vs expected 'acknowledgement/core_types.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/twoface/acknowledgement/CoreTypesTest.kt` | `// port-lint: tests acknowledgement/core_types.rs` | `// port-lint: tests acknowledgement/core_types.rs` | `acknowledgement/core_types.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:acknowledgement/core_types.rs' vs expected 'acknowledgement/core_types.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/twoface/acknowledgement/Mod.kt` | `// port-lint: source acknowledgement/mod.rs` | `// port-lint: source acknowledgement/mod.rs` | `acknowledgement/mod.rs` | `port-lint provenance header matched only after fallback normalization: 'acknowledgement/mod.rs' vs expected 'acknowledgement/mod.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/twoface/acknowledgement/ModTest.kt` | `// port-lint: tests acknowledgement/mod.rs` | `// port-lint: tests acknowledgement/mod.rs` | `acknowledgement/mod.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:acknowledgement/mod.rs' vs expected 'acknowledgement/mod.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/twoface/syntax/Syntax.kt` | `// port-lint: source syntax.rs` | `// port-lint: source syntax.rs` | `syntax.rs` | `port-lint provenance header matched only after fallback normalization: 'syntax.rs' vs expected 'syntax.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/twoface/syntax/SyntaxTest.kt` | `// port-lint: tests syntax.rs` | `// port-lint: tests syntax.rs` | `syntax.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:syntax.rs' vs expected 'syntax.rs'` |
