# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 6/6 (100.0%)
- **Function parity:** 10/10 matched (target 30) — 100.0%
- **Class/type parity:** 6/6 matched (target 17) — 100.0%
- **Combined symbol parity:** 16/16 matched (target 47) — 100.0%
- **Average inline-code cosine:** 0.44 (function body across 4 matched files)
- **Average documentation cosine:** 0.54 (doc text across 4 matched files)
- **Cheat-zeroed Files:** 0
- **Critical Issues:** 5 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. theme.core_types

- **Target:** `theme.CoreTypes`
- **Similarity:** 0.26
- **Dependents:** 0
- **Priority Score:** 607.4
- **Functions:** 4/4 matched (target 8)
- **Missing functions:** _none_
- **Types:** 2/2 matched (target 5)
- **Missing types:** _none_

### 2. acknowledgement.core_types

- **Target:** `acknowledgement.CoreTypes`
- **Similarity:** 0.79
- **Dependents:** 0
- **Priority Score:** 602.1
- **Functions:** 3/3 matched (target 14)
- **Missing functions:** _none_
- **Types:** 3/3 matched (target 6)
- **Missing types:** _none_

### 3. syntax

- **Target:** `syntax.Syntax`
- **Similarity:** 0.22
- **Dependents:** 0
- **Priority Score:** 207.8
- **Functions:** 2/2 matched (target 6)
- **Missing functions:** _none_
- **Types:** 0/0 matched (target 3)
- **Missing types:** _none_

### 4. lib

- **Target:** `twoface.Lib`
- **Similarity:** 0.46
- **Dependents:** 0
- **Priority Score:** 205.4
- **Functions:** 1/1 matched (target 2)
- **Missing functions:** _none_
- **Types:** 1/1 matched (target 3)
- **Missing types:** _none_
- **Tests:** 1/1 matched

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
| `theme.mod` | `theme.Mod` | `theme/mod` |
| `acknowledgement.mod` | `acknowledgement.Mod` | `acknowledgement/mod` |

