=== Deep Analysis: tmp/two-face/src (rust) -> src/commonMain/kotlin (kotlin) ===

Scanning source codebase (rust)...
Codebase: tmp/two-face/src (rust)
  Files: 6
  Total imports: 14

Scanning target codebase (kotlin)...
Codebase: src/commonMain/kotlin (kotlin)
  Files: 12
  Total imports: 27

Comparing codebases...
Computing AST similarities...

=== Codebase Comparison Report ===

Source: tmp/two-face/src (6 files)
Target: src/commonMain/kotlin (12 files)
Scoring invariant: FnSim is required function body/parameter similarity. Class/type and symbol parity are reported beside it; whole-file shape is diagnostic only.

Matched:   6 files
Unmatched: 0 source, 0 target

=== Matched Files (by porting priority) ===

Source                        Target                        FnSim     Dependents FunctionParityTypeParity  Priority
 --------------------------------------------------------------------------------------------------------------------------
theme.mod                     theme.Mod [STUB]              0.00      0          9/9           3/3         1210.0    
theme.core_types              theme.CoreTypes               0.26      0          4/4           2/2         607.4     
acknowledgement.core_types    acknowledgement.CoreTypes     0.79      0          3/3           3/3         602.1     
acknowledgement.mod           acknowledgement.Mod [STUB]    0.00      0          4/4           0/0         410.0     
syntax                        syntax.Syntax                 0.22      0          2/2           0/0         207.8     
lib                           twoface.Lib                   0.46      0          1/1           1/1         205.4     

=== Function and Symbol Details ===

theme.mod -> theme.Mod [STUB]
  similarity: 0.00, priority: 1210.0, dependents: 0
  functions: 9/9 matched (target total: 16, required body score: 0.00)
  missing functions: none
  types: 3/3 matched (target total: 4)
  missing types: none
  *** CHEAT DETECTION / SCORING FAILURE ***
  function-by-function score forced to 0: target contains TODO/stub/placeholder markers in function bodies
  tests: 2/2 matched

theme.core_types -> theme.CoreTypes
  similarity: 0.26, priority: 607.4, dependents: 0
  functions: 4/4 matched (target total: 8, required body score: 0.26)
  missing functions: none
  types: 2/2 matched (target total: 5)
  missing types: none

acknowledgement.core_types -> acknowledgement.CoreTypes
  similarity: 0.79, priority: 602.1, dependents: 0
  functions: 3/3 matched (target total: 14, required body score: 0.79)
  missing functions: none
  types: 3/3 matched (target total: 6)
  missing types: none

acknowledgement.mod -> acknowledgement.Mod [STUB]
  similarity: 0.00, priority: 410.0, dependents: 0
  functions: 4/4 matched (target total: 7, required body score: 0.00)
  missing functions: none
  types: 0/0 matched (target total: 1)
  missing types: none
  *** CHEAT DETECTION / SCORING FAILURE ***
  function-by-function score forced to 0: target contains TODO/stub/placeholder markers in function bodies

syntax -> syntax.Syntax
  similarity: 0.22, priority: 207.8, dependents: 0
  functions: 2/2 matched (target total: 6, required body score: 0.22)
  missing functions: none
  types: 0/0 matched (target total: 3)
  missing types: none

lib -> twoface.Lib
  similarity: 0.46, priority: 205.4, dependents: 0
  functions: 1/1 matched (target total: 2, required body score: 0.46)
  missing functions: none
  types: 1/1 matched (target total: 3)
  missing types: none
  tests: 1/1 matched


=== Scores Forced To 0 ===

  - theme.mod -> theme.Mod: target contains TODO/stub/placeholder markers in function bodies
  - acknowledgement.mod -> acknowledgement.Mod: target contains TODO/stub/placeholder markers in function bodies

=== Porting Quality Summary ===

Matched by exact header:          6 / 6
Matched by provenance fallback:   0 / 6
Matched by name:                  0 / 6
Total TODOs in target: 0
Total lint errors:    0
Stub files:           2

=== Big Picture ===

- Missing files: 0
- Incomplete ports (similarity < 60%): 5
- Stub files: 2
- Files missing functions: 0 (total deficit: 0 functions)
- Type definitions missing: 0
- Files missing tests: 0 (total deficit: 0 unported `#[test]` functions)
- Documentation coverage: 291 / 1196 lines (24%)

Primary focus: replace stub files with real implementations

=== Files with Issues ===

File                          Similarity LineRatio  FunctionParityTests     TODOs Lint  Status
----------------------------------------------------------------------------------------------------
theme.Mod [STUB]              0.00       0.00       9/9           2/2       0     0     STUB
theme.CoreTypes               0.26       0.00       4/4           -         0     0     LOW_SIM
acknowledgement.Mod [STUB]    0.00       0.00       4/4           -         0     0     STUB
syntax.Syntax                 0.22       0.00       2/2           -         0     0     LOW_SIM
twoface.Lib                   0.46       0.00       1/1           1/1       0     0     

=== Porting Recommendations ===

Incomplete ports (similarity < 60%): 5
Missing files: 0

Incomplete ports to complete:
  theme.mod                      similarity=0.00 function_parity=9/9 dependents=0 [STUB]
  theme.core_types               similarity=0.26 function_parity=4/4 dependents=0
  acknowledgement.mod            similarity=0.00 function_parity=4/4 dependents=0 [STUB]
  syntax                         similarity=0.22 function_parity=2/2 dependents=0
  lib                            similarity=0.46 function_parity=1/1 dependents=0

=== Documentation Gaps ===

There is missing documentation that is hurting overall scoring.
Documentation coverage: 291 / 1196 lines (24%)
Files with >20% doc gap: 6

File                          Src Docs    Tgt Docs    Gap %     DocSim    DocAmt    DocEq     
----------------------------------------------------------------------------------------------
theme.mod                     576         108         81%       0.03      0.19      0.11      
lib                           332         6           98%       0.09      0.02      0.06      
acknowledgement.core_types    122         69          43%       0.97      0.57      0.77      
theme.core_types              88          56          36%       0.71      0.64      0.67      
acknowledgement.mod           32          16          50%       0.94      0.50      0.72      
syntax                        46          36          21%       0.39      0.78      0.59      

=== Generating Reports ===

✅ Generated: port_status_report.md
✅ Generated: high_priority_ports.md
✅ Generated: NEXT_ACTIONS.md
✅ Generated: port_lint_proposed_changes.md

📁 All reports generated successfully!
