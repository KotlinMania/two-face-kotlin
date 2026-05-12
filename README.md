# two-face-kotlin in Kotlin

[![GitHub link](https://img.shields.io/badge/GitHub-KotlinMania%2Ftwo--face--kotlin-blue.svg)](https://github.com/KotlinMania/two-face-kotlin)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kotlinmania/two-face-kotlin)](https://central.sonatype.com/artifact/io.github.kotlinmania/two-face-kotlin)
[![Build status](https://img.shields.io/github/actions/workflow/status/KotlinMania/two-face-kotlin/ci.yml?branch=main)](https://github.com/KotlinMania/two-face-kotlin/actions)

This is a Kotlin Multiplatform line-by-line transliteration port of [`CosmicHorrorDev/two-face`](https://github.com/CosmicHorrorDev/two-face).

**Original Project:** This port is based on [`CosmicHorrorDev/two-face`](https://github.com/CosmicHorrorDev/two-face). All design credit and project intent belong to the upstream authors; this repository is a faithful port to Kotlin Multiplatform with no behavioural changes intended.

### Porting status

This is an **in-progress port**. The goal is feature parity with the upstream Rust crate while providing a native Kotlin Multiplatform API. Every Kotlin file carries a `// port-lint: source <path>` header naming its upstream Rust counterpart so the AST-distance tool can track provenance.

---

## Upstream README — `CosmicHorrorDev/two-face`

> The text below is reproduced and lightly edited from [`https://github.com/CosmicHorrorDev/two-face`](https://github.com/CosmicHorrorDev/two-face). It is the upstream project's own description and remains under the upstream authors' authorship; links have been rewritten to absolute upstream URLs so they continue to resolve from this repository.

> [!IMPORTANT]
> Moved to codeberg. Issues still open here for people who want to use them :)
>
> <https://codeberg.org/CosmicHarper/two-face>

---

## _two-face — regex lover club 🐭_

[![build status](https://img.shields.io/github/actions/workflow/status/CosmicHorrorDev/two-face/CI.yml?branch=main)](https://github.com/CosmicHorrorDev/two-face/actions)
[![Crates.io](https://img.shields.io/crates/v/two-face.svg)](https://crates.io/crates/two-face)
[![Documentation](https://img.shields.io/docsrs/two-face/latest)](https://docs.rs/two-face/latest/two-face/)
[![codecov](https://codecov.io/gh/CosmicHorrorDev/two-face/graph/badge.svg?token=MUORSBCHF2)](https://codecov.io/gh/CosmicHorrorDev/two-face)

Extra syntax and theme definitions for
[`syntect`](https://docs.rs/syntect/latest/syntect/) including many common ones
that are missing from the default set like TOML, TypeScript, and Dockerfile.
Curated by the [`bat` Project](https://github.com/sharkdp/bat)

## Example

The following

```console
$ cargo add two-face --features syntect-default-onig
```

```rust
use two_face::re_exports::syntect;

const TOML_TEXT: &str = "\
[section]
key = 123
";

fn main() {
    let syn_set = two_face::syntax::extra_newlines();
    let theme_set = two_face::theme::extra();

    let syn_ref = syn_set.find_syntax_by_extension("toml").unwrap();
    let theme = &theme_set[two_face::theme::EmbeddedThemeName::Nord];
    let htmlified = syntect::html::highlighted_html_for_string(
        TOML_TEXT,
        &syn_set,
        syn_ref,
        theme
    ).unwrap();

    println!("{htmlified}");
}
```

will print this

```html
<pre style="background-color:#2e3440;">
<span style="color:#d8dee9;">[section]
</span><span style="color:#81a1c1;">key </span><span style="color:#d8dee9;">= </span><span style="color:#b48ead;">123
</span></pre>
```

## Feature Flags

The feature flags are divided by `syntect`'s underlying regex implementation
with [`Oniguruma`](https://github.com/kkos/oniguruma) aka `onig` being the
default and [`fancy-regex`](https://github.com/fancy-regex/fancy-regex) aka
`fancy` as an alternative pure-Rust implementation. `fancy`: however, doesn't
support all of the features used by some of the syntax definitions, so some of
the defintions are excluded when `fancy` is selected\* to keep the regex
compilation infallible. This means that it's important to match whichever regex
implementation `syntect` is using

_\* This is also why fancy's bundled syntax definitions are smaller than onig's_

default: `syntect-onig`

| Feature | Desc. |
| :---: | :--- |
| `syntect-onig` / `syntect-fancy` | Enables the minimal feature set that we require from `syntect` |
| `syntect-default-onig` / `syntect-default-fancy` | The mimimal feature sets along with `syntect`'s default feature set (useful when using the `syntect` re-export) |

## Embedded Asset Sizes

This crate embeds some reasonably large assets in the final binary in order to
work. Luckily [the linker is smart enough to discard unused assets](https://github.com/CosmicHorrorDev/two-face/blob/0979a0dd5faf2197f6c37ee2194e20bbf0b77ce7/tests/linker_smarts_mixed_partial.rs#L11-L25), so you
generally only pay for what you use

For reference here are the sizes associated with their different functions

| function | `two-face` (KiB) | `syntect` (KiB) |
| ---: | ---: | ---: |
| [`acknowledgement::listing()`](https://docs.rs/two-face/latest/two_face/acknowledgement/fn.listing.html) | 11 | - |
| [`syntax::extra_newlines()`](https://docs.rs/two-face/latest/two_face/syntax/fn.extra_newlines.html) (onig) | 961 | 360 |
| ^^ (fancy) | 937 | ^^ |
| [`syntax::extra_no_newlines()`](https://docs.rs/two-face/latest/two_face/syntax/fn.extra_no_newlines.html) (onig) | 959 | 359 |
| ^^ (fancy) | 935 | ^^ |
| [`theme::extra()`](https://docs.rs/two-face/latest/two_face/theme/index.html) | 61 | 5 |

In short the syntax definitions are the real chonky part, and if you're
switching from `syntect` to `two-face`, then you can expect a ~0.6MiB increase
in binary size from them (in exchange for _a lot_ of syntax definitions)

## Syntaxes

The full listing of all syntaxes included in [`two_face::syntax`](https://docs.rs/two-face/latest/two_face/syntax/index.html)

- \* Excluded when using the `fancy-regex` implementation
- † Included in `syntect`'s bundled defaults

|  | Syntax Definition |
| :---: | :---: |
| A | ActionScript†, Ada, Apache Conf, AppleScript†, AsciiDoc, ASP†, ARM Assembly\*, Assembly (x86\_64), AWK |
| B | Bash†, Batch File†, BibTeX† |
| C | C†, C#†, C++†, Cabal, CFML, Clojure†, CMake, CoffeeScript, Crontab, Crystal, CSS†, CSV† |
| D | D†, Dart, debsources, Dockerfile, DotENV, Diff† |
| E | Elixir, Elm, Email, Erlang† |
| F | F#, Fish, Fortran |
| G | GDScript (Godot Engine), Git (commit, config, ignore, etc.)†, GLSL, Go†, GraphQL, Graphviz (DOT)†, Groff/troff†, Groovy† |
| H | Haskell†, HTML† |
| I | Idris, INI |
| J | Java†, Javadoc†, Java Server Page (JSP)†, JavaScript†, JavaScript (Babel)\*, Jinja2, JQ, JSON†, Julia |
| K | Kotlin |
| L | LaTeX†, LaTeX Log†, Lean, LESS, Lisp†, Literate Haskell†, LiveScript, LLVM, Lua† |
| M | Makefile†, Manpage, Markdown†, MATLAB†, Mediawiki, MultiMarkdown† |
| N | NAnt Build File†, Nginx, Nim, Ninja, Nix, NSIS |
| O | Objective-C†, Objective-C++†, OCaml†, OCamllex†, OCamlyacc†, Odin, Org Mode |
| P | Pascal†, Perl†, PHP†, PowerShell\*, Protobuf, Puppet, PureScript, Python† |
| Q | QML |
| R | R†, Racket, Rd†, Rego, Regular Expression†, Requirements.txt, reStructuredText†, Robot Framework, Ruby†, Ruby Haml†, Ruby on Rails†, Ruby Slim, Rust† |
| S | Sass, Scala†, SCSS, Salt State SLS\*, SML, Solidity, SQL†, Strace, Stylus, Svelte, Swift, SystemVerilog |
| T | Tcl†, Terraform, TeX†, Textile†, Todo.txt, TOML, TypeScript, TypescriptReact, Typst |
| V | Varlink, Verilog, VHDL, VimL, Vue, Vyper |
| W | WGSL |
| X | XML† |
| Y | YAML† |
| Z | Zig |

## Themes

_Note: For visual examples of all of the embedded themes look at the docs for
[`two_face::theme::EmbeddedThemeName`](https://docs.rs/two-face/latest/two_face/theme/enum.EmbeddedThemeName.html)_

The full listing of themes provided by `two_face::theme`. Many of these themes
only make sense situationally, so you'll likely want to only expose a subset

- † Included in `syntect`'s bundled defaults

|  | Theme |
| :---: | :---: |
| 1 | 1337 (aka leet) |
| A | Ansi |
| B | Base16, Base16-256, Base16-Eighties (dark)†, Base16-Mocha (dark)†, Base16-Ocean (light/dark)† |
| C | Catppuccin (frappe, latte, macchiato, mocha), Coldark (cold/dark aka light/dark) |
| D | DarkNeon, Dracula |
| G | GitHub, gruvbox (light/dark) |
| I | InspiredGitHub† |
| M | Monokai Extended (plain, bright, light, and origin) |
| N | Nord |
| O | One Half (light/dark) |
| S | Solarized (light/dark)†, Sublime Snazzy |
| T | TwoDark |
| Z | Zenburn |

## Legal

Most of the code for generating the syntax and theme dumps along with curating
said syntax and themes is taken from [`bat`](https://github.com/sharkdp/bat).
Because of this we also mirror `bat`'s licenses by being dual licensed under MIT
and Apache-2.0.

See the [LICENSE-APACHE](https://github.com/CosmicHorrorDev/two-face/blob/HEAD/LICENSE-APACHE) and [LICENSE-MIT](https://github.com/CosmicHorrorDev/two-face/blob/HEAD/LICENSE-MIT) files
for license details.

The embedded syntax definitions and assets also have their own licenses which
are compiled into
[this markdown file](https://github.com/CosmicHorrorDev/two-face/blob/main/generated/acknowledgements_full.md)
along with programmatic access in the `acknowledgement` module.

### `bat`'s NOTICE

Copyright (c) 2018-2021 bat-developers (https://github.com/sharkdp/bat).

bat is made available under the terms of either the MIT License or the Apache
License 2.0, at your option.

See the [LICENSE-APACHE](https://github.com/CosmicHorrorDev/two-face/blob/HEAD/bat/LICENSE-APACHE) and
[LICENSE-MIT](https://github.com/CosmicHorrorDev/two-face/blob/HEAD/bat/LICENSE-MIT) files for license details.

---

## About this Kotlin port

### Installation

```kotlin
dependencies {
    implementation("io.github.kotlinmania:two-face-kotlin:0.1.0")
}
```

### Building

```bash
./gradlew build
./gradlew test
```

### Targets

- macOS arm64
- Linux x64
- Windows mingw-x64
- iOS arm64 / simulator-arm64 (Swift export + XCFramework)
- JS (browser + Node.js)
- Wasm-JS (browser + Node.js)
- Android (API 24+)

### Porting guidelines

See [AGENTS.md](AGENTS.md) and [CLAUDE.md](CLAUDE.md) for translator discipline, port-lint header convention, and Rust → Kotlin idiom mapping.

### License

This Kotlin port is distributed under the same MIT license as the upstream [`CosmicHorrorDev/two-face`](https://github.com/CosmicHorrorDev/two-face). See [LICENSE](LICENSE) (and any sibling `LICENSE-*` / `NOTICE` files mirrored from upstream) for the full text.

Original work copyrighted by the two-face authors.  
Kotlin port: Copyright (c) 2026 Sydney Renee and The Solace Project.

### Acknowledgments

Thanks to the [`CosmicHorrorDev/two-face`](https://github.com/CosmicHorrorDev/two-face) maintainers and contributors for the original Rust implementation. This port reproduces their work in Kotlin Multiplatform; bug reports about upstream design or behavior should go to the upstream repository.
