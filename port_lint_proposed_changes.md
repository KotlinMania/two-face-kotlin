# port-lint Proposed Changes

**Generated:** 2026-08-31
**Source:** tmp/two-face/src
**Target:** src/commonMain/kotlin/io/github/kotlinmania/twoface

These are review proposals only. They are emitted when a Rust -> Kotlin pair matches only after fallback normalization, so the existing `port-lint` header is not an exact provenance match.

| Target file | Current header | Proposed header | Source path | Reason |
|-------------|----------------|-----------------|-------------|--------|
| `src/commonMain/kotlin/io/github/kotlinmania/twoface/theme/CoreTypes.kt` | `// port-lint: source two-face/src/theme/core_types.rs` | `// port-lint: source theme/core_types.rs` | `theme/core_types.rs` | `port-lint provenance header matched only after fallback normalization: 'two-face/src/theme/core_types.rs' vs expected 'theme/core_types.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/twoface/theme/CoreTypesTest.kt` | `// port-lint: tests two-face/src/theme/core_types.rs` | `// port-lint: tests theme/core_types.rs` | `theme/core_types.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:two-face/src/theme/core_types.rs' vs expected 'theme/core_types.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/twoface/acknowledgement/CoreTypes.kt` | `// port-lint: source two-face/src/acknowledgement/core_types.rs` | `// port-lint: source acknowledgement/core_types.rs` | `acknowledgement/core_types.rs` | `port-lint provenance header matched only after fallback normalization: 'two-face/src/acknowledgement/core_types.rs' vs expected 'acknowledgement/core_types.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/twoface/acknowledgement/CoreTypesTest.kt` | `// port-lint: tests two-face/src/acknowledgement/core_types.rs` | `// port-lint: tests acknowledgement/core_types.rs` | `acknowledgement/core_types.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:two-face/src/acknowledgement/core_types.rs' vs expected 'acknowledgement/core_types.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/twoface/Lib.kt` | `// port-lint: source two-face/src/lib.rs` | `// port-lint: source lib.rs` | `lib.rs` | `port-lint provenance header matched only after fallback normalization: 'two-face/src/lib.rs' vs expected 'lib.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/twoface/LibTest.kt` | `// port-lint: tests two-face/src/lib.rs` | `// port-lint: tests lib.rs` | `lib.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:two-face/src/lib.rs' vs expected 'lib.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/twoface/syntax/Syntax.kt` | `// port-lint: source two-face/src/syntax.rs` | `// port-lint: source syntax.rs` | `syntax.rs` | `port-lint provenance header matched only after fallback normalization: 'two-face/src/syntax.rs' vs expected 'syntax.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/twoface/syntax/SyntaxTest.kt` | `// port-lint: tests two-face/src/syntax.rs` | `// port-lint: tests syntax.rs` | `syntax.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:two-face/src/syntax.rs' vs expected 'syntax.rs'` |
