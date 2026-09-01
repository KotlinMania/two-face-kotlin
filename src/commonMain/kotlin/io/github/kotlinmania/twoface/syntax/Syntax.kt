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
        SyntaxReference("ActionScript", listOf("as")),
        SyntaxReference("Ada", listOf("ada", "adb", "ads")),
        SyntaxReference("Apache Conf", listOf("conf", "htaccess")),
        SyntaxReference("AppleScript", listOf("applescript", "scpt")),
        SyntaxReference("AsciiDoc", listOf("adoc", "asciidoc")),
        SyntaxReference("ASP", listOf("asp")),
        SyntaxReference("ARM Assembly", listOf("s", "S")),
        SyntaxReference("Assembly (x86_64)", listOf("asm", "s")),
        SyntaxReference("AWK", listOf("awk")),
        SyntaxReference("Bash", listOf("sh", "bash", "zsh")),
        SyntaxReference("Batch File", listOf("bat", "cmd")),
        SyntaxReference("BibTeX", listOf("bib")),
        SyntaxReference("C", listOf("c", "h")),
        SyntaxReference("C#", listOf("cs")),
        SyntaxReference("C++", listOf("cpp", "cc", "cxx", "hpp", "hh", "hxx")),
        SyntaxReference("Cabal", listOf("cabal")),
        SyntaxReference("CFML", listOf("cfm", "cfc")),
        SyntaxReference("Clojure", listOf("clj", "cljs", "cljc", "edn")),
        SyntaxReference("CMake", listOf("cmake", "CMakeLists.txt")),
        SyntaxReference("CoffeeScript", listOf("coffee")),
        SyntaxReference("Crontab", listOf("crontab")),
        SyntaxReference("Crystal", listOf("cr")),
        SyntaxReference("CSS", listOf("css")),
        SyntaxReference("CSV", listOf("csv")),
        SyntaxReference("D", listOf("d")),
        SyntaxReference("Dart", listOf("dart")),
        SyntaxReference("debsources", listOf("sources.list")),
        SyntaxReference("Dockerfile", listOf("Dockerfile", "dockerfile")),
        SyntaxReference("DotENV", listOf("env")),
        SyntaxReference("Diff", listOf("diff", "patch")),
        SyntaxReference("Elixir", listOf("ex", "exs")),
        SyntaxReference("Elm", listOf("elm")),
        SyntaxReference("Email", listOf("eml", "msg")),
        SyntaxReference("Erlang", listOf("erl", "hrl")),
        SyntaxReference("F#", listOf("fs", "fsi", "fsx")),
        SyntaxReference("Fish", listOf("fish")),
        SyntaxReference("Fortran", listOf("f", "f90", "f95")),
        SyntaxReference("GDScript", listOf("gd")),
        SyntaxReference("Git", listOf("gitcommit", "gitconfig", "gitignore")),
        SyntaxReference("GLSL", listOf("glsl", "vert", "frag")),
        SyntaxReference("Go", listOf("go")),
        SyntaxReference("GraphQL", listOf("graphql", "gql")),
        SyntaxReference("Graphviz (DOT)", listOf("dot", "gv")),
        SyntaxReference("Groff/troff", listOf("roff", "man")),
        SyntaxReference("Groovy", listOf("groovy", "gvy", "gradle")),
        SyntaxReference("Haskell", listOf("hs", "lhs")),
        SyntaxReference("HTML", listOf("html", "htm")),
        SyntaxReference("Idris", listOf("idr")),
        SyntaxReference("INI", listOf("ini")),
        SyntaxReference("Java", listOf("java")),
        SyntaxReference("Javadoc", listOf("javadoc")),
        SyntaxReference("Java Server Page (JSP)", listOf("jsp")),
        SyntaxReference("JavaScript", listOf("js", "mjs", "cjs")),
        SyntaxReference("JavaScript (Babel)", listOf("jsx")),
        SyntaxReference("Jinja2", listOf("jinja", "j2")),
        SyntaxReference("JQ", listOf("jq")),
        SyntaxReference("JSON", listOf("json")),
        SyntaxReference("Julia", listOf("jl")),
        SyntaxReference("Kotlin", listOf("kt", "kts")),
        SyntaxReference("LaTeX", listOf("tex", "latex")),
        SyntaxReference("LaTeX Log", listOf("log")),
        SyntaxReference("Lean", listOf("lean")),
        SyntaxReference("LESS", listOf("less")),
        SyntaxReference("Lisp", listOf("lisp", "lsp", "cl")),
        SyntaxReference("Literate Haskell", listOf("lhs")),
        SyntaxReference("LiveScript", listOf("ls")),
        SyntaxReference("LLVM", listOf("ll")),
        SyntaxReference("Lua", listOf("lua")),
        SyntaxReference("Makefile", listOf("Makefile", "makefile", "mk")),
        SyntaxReference("Manpage", listOf("man")),
        SyntaxReference("Markdown", listOf("md", "markdown")),
        SyntaxReference("MATLAB", listOf("matlab", "m")),
        SyntaxReference("Mediawiki", listOf("mediawiki", "wiki")),
        SyntaxReference("MultiMarkdown", listOf("mmd")),
        SyntaxReference("NAnt Build File", listOf("build")),
        SyntaxReference("Nginx", listOf("nginx.conf")),
        SyntaxReference("Nim", listOf("nim")),
        SyntaxReference("Ninja", listOf("ninja")),
        SyntaxReference("Nix", listOf("nix")),
        SyntaxReference("NSIS", listOf("nsi", "nsh")),
        SyntaxReference("Objective-C", listOf("m")),
        SyntaxReference("Objective-C++", listOf("mm")),
        SyntaxReference("OCaml", listOf("ml", "mli")),
        SyntaxReference("OCamllex", listOf("mll")),
        SyntaxReference("OCamlyacc", listOf("mly")),
        SyntaxReference("Odin", listOf("odin")),
        SyntaxReference("Org Mode", listOf("org")),
        SyntaxReference("Pascal", listOf("pas", "pp")),
        SyntaxReference("Perl", listOf("pl", "pm")),
        SyntaxReference("PHP", listOf("php")),
        SyntaxReference("PowerShell", listOf("ps1", "psm1")),
        SyntaxReference("Protobuf", listOf("proto")),
        SyntaxReference("Puppet", listOf("pp")),
        SyntaxReference("PureScript", listOf("purs")),
        SyntaxReference("Python", listOf("py")),
        SyntaxReference("QML", listOf("qml")),
        SyntaxReference("R", listOf("r", "R")),
        SyntaxReference("Racket", listOf("rkt")),
        SyntaxReference("Rd", listOf("rd")),
        SyntaxReference("Rego", listOf("rego")),
        SyntaxReference("Regular Expression", listOf("re")),
        SyntaxReference("Requirements.txt", listOf("requirements.txt")),
        SyntaxReference("reStructuredText", listOf("rst")),
        SyntaxReference("Robot Framework", listOf("robot")),
        SyntaxReference("Ruby", listOf("rb")),
        SyntaxReference("Ruby Haml", listOf("haml")),
        SyntaxReference("Ruby on Rails", listOf("rhtml", "erb")),
        SyntaxReference("Ruby Slim", listOf("slim")),
        SyntaxReference("Rust", listOf("rs")),
        SyntaxReference("Sass", listOf("sass")),
        SyntaxReference("Scala", listOf("scala")),
        SyntaxReference("SCSS", listOf("scss")),
        SyntaxReference("Salt State SLS", listOf("sls")),
        SyntaxReference("SML", listOf("sml", "sig")),
        SyntaxReference("Solidity", listOf("sol")),
        SyntaxReference("SQL", listOf("sql")),
        SyntaxReference("Strace", listOf("strace")),
        SyntaxReference("Stylus", listOf("styl")),
        SyntaxReference("Svelte", listOf("svelte")),
        SyntaxReference("Swift", listOf("swift")),
        SyntaxReference("SystemVerilog", listOf("sv", "svh")),
        SyntaxReference("Tcl", listOf("tcl")),
        SyntaxReference("Terraform", listOf("tf", "tfvars")),
        SyntaxReference("TeX", listOf("tex")),
        SyntaxReference("Textile", listOf("textile")),
        SyntaxReference("Todo.txt", listOf("todo.txt")),
        SyntaxReference("TOML", listOf("toml")),
        SyntaxReference("TypeScript", listOf("ts", "tsx")),
        SyntaxReference("TypescriptReact", listOf("tsx")),
        SyntaxReference("Typst", listOf("typ")),
        SyntaxReference("Varlink", listOf("varlink")),
        SyntaxReference("Verilog", listOf("v", "vh")),
        SyntaxReference("VHDL", listOf("vhd", "vhdl")),
        SyntaxReference("VimL", listOf("vim")),
        SyntaxReference("Vue", listOf("vue")),
        SyntaxReference("Vyper", listOf("vy")),
        SyntaxReference("WGSL", listOf("wgsl")),
        SyntaxReference("XML", listOf("xml")),
        SyntaxReference("YAML", listOf("yaml", "yml")),
        SyntaxReference("Zig", listOf("zig")),
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
