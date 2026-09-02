# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 6/6 (100.0%)
- **Function parity:** 22/22 matched (target 51) — 100.0%
- **Class/type parity:** 8/8 matched (target 19) — 100.0%
- **Combined symbol parity:** 30/30 matched (target 70) — 100.0%
- **Average inline-code cosine:** 0.44 (function body across 4 matched files)
- **Average documentation cosine:** 0.54 (doc text across 4 matched files)
- **Cheat-zeroed Files:** 2
- **Critical Issues:** 5 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. theme.mod

- **Target:** `theme.Mod [STUB] [PROVENANCE-FALLBACK]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 1210.0
- **Functions:** 9/9 matched (target 16)
- **Missing functions:** _none_
- **Types:** 3/3 matched (target 4)
- **Missing types:** _none_
- **Tests:** 2/2 matched
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `theme/mod.rs` vs expected `theme/mod.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tests:theme/mod.rs` vs expected `theme/mod.rs`
- **Proposed provenance header:** `// port-lint: source theme/mod.rs` (current: `// port-lint: source theme/mod.rs`)
- **Proposed provenance header:** `// port-lint: tests theme/mod.rs` (current: `// port-lint: tests theme/mod.rs`)
- **Lint issues:** 2

### 2. theme.core_types

- **Target:** `theme.CoreTypes [PROVENANCE-FALLBACK]`
- **Similarity:** 0.26
- **Dependents:** 0
- **Priority Score:** 607.4
- **Functions:** 4/4 matched (target 8)
- **Missing functions:** _none_
- **Types:** 2/2 matched (target 5)
- **Missing types:** _none_
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `theme/core_types.rs` vs expected `theme/core_types.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tests:theme/core_types.rs` vs expected `theme/core_types.rs`
- **Proposed provenance header:** `// port-lint: source theme/core_types.rs` (current: `// port-lint: source theme/core_types.rs`)
- **Proposed provenance header:** `// port-lint: tests theme/core_types.rs` (current: `// port-lint: tests theme/core_types.rs`)
- **Lint issues:** 2

### 3. acknowledgement.core_types

- **Target:** `acknowledgement.CoreTypes [PROVENANCE-FALLBACK]`
- **Similarity:** 0.79
- **Dependents:** 0
- **Priority Score:** 602.1
- **Functions:** 3/3 matched (target 14)
- **Missing functions:** _none_
- **Types:** 3/3 matched (target 6)
- **Missing types:** _none_
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `acknowledgement/core_types.rs` vs expected `acknowledgement/core_types.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tests:acknowledgement/core_types.rs` vs expected `acknowledgement/core_types.rs`
- **Proposed provenance header:** `// port-lint: source acknowledgement/core_types.rs` (current: `// port-lint: source acknowledgement/core_types.rs`)
- **Proposed provenance header:** `// port-lint: tests acknowledgement/core_types.rs` (current: `// port-lint: tests acknowledgement/core_types.rs`)
- **Lint issues:** 2

### 4. acknowledgement.mod

- **Target:** `acknowledgement.Mod [STUB] [PROVENANCE-FALLBACK]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 410.0
- **Functions:** 4/4 matched (target 7)
- **Missing functions:** _none_
- **Types:** 0/0 matched (target 1)
- **Missing types:** _none_
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `acknowledgement/mod.rs` vs expected `acknowledgement/mod.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tests:acknowledgement/mod.rs` vs expected `acknowledgement/mod.rs`
- **Proposed provenance header:** `// port-lint: source acknowledgement/mod.rs` (current: `// port-lint: source acknowledgement/mod.rs`)
- **Proposed provenance header:** `// port-lint: tests acknowledgement/mod.rs` (current: `// port-lint: tests acknowledgement/mod.rs`)
- **Lint issues:** 2

### 5. two-face.syntax

- **Target:** `syntax.Syntax [PROVENANCE-FALLBACK]`
- **Similarity:** 0.22
- **Dependents:** 0
- **Priority Score:** 207.8
- **Functions:** 2/2 matched (target 6)
- **Missing functions:** _none_
- **Types:** 0/0 matched (target 3)
- **Missing types:** _none_
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `syntax.rs` vs expected `syntax.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tests:syntax.rs` vs expected `syntax.rs`
- **Proposed provenance header:** `// port-lint: source syntax.rs` (current: `// port-lint: source syntax.rs`)
- **Proposed provenance header:** `// port-lint: tests syntax.rs` (current: `// port-lint: tests syntax.rs`)
- **Lint issues:** 2

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present

## Reexport / Wiring Modules

These files match `reexport_modules` patterns in `.ast_distance_config.json`. They are filtered out of
normal priority and missing-file ladders because they are wiring
modules, not direct logic ports. Consult them for call-site routing;
do not treat them as the next implementation target by default.

### Matched

| Source | Target | Path |
|--------|--------|------|
| `two-face.lib` | `twoface.Lib` | `two-face/src/lib` |

