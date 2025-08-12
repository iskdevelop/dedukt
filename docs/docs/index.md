# DeduKt

**DeduKt** is a powerful symbolic computation, mathematical reasoning, and simulation platform built with Kotlin Multiplatform.

## Features

- **Type-safe Kotlin DSL** for symbolic computation within Kotlin applications
- **Standalone DSL** with its own syntax for external use
- **Language Server Protocol** support for rich IDE features
- **Web-based notebook interface** for interactive exploration
- **Cross-platform** support (JVM, JavaScript, Native)

## Quick Start

=== "Kotlin DSL"

    ```kotlin
    import io.dedukt.dsl.*

    fun main() {
        dedukt {
            val result = expression {
                symbol("x")
            }
            println(result)
        }
    }
    ```

=== "External DSL"

    ```dedukt
    let x = symbol("x")
    let y = symbol("y")
    let expr = x + y * 2
    solve(expr = 0, x)
    ```

=== "Notebook"

    Open your browser to `http://localhost:8080` after starting the notebook server:
    
    ```bash
    ./gradlew :notebook:run
    ```

## Architecture

DeduKt is built with a modular architecture:

- **Core**: Platform-agnostic computation engine
- **DSL**: Type-safe internal DSL and external DSL parser
- **LSP**: Language server for IDE integration
- **Notebook**: Web-based interactive environment
- **Docs**: Comprehensive documentation

## Getting Started

Choose your integration path:

1. **[Installation Guide](getting-started/installation.md)** - Set up DeduKt in your environment
2. **[Quick Start](getting-started/quick-start.md)** - Get up and running in minutes
3. **[Examples](examples/basic-usage.md)** - See DeduKt in action

## Community

- **GitHub**: [github.com/dedukt/dedukt](https://github.com/dedukt/dedukt)
- **Documentation**: [dedukt.io](https://dedukt.io)
- **Issues**: [GitHub Issues](https://github.com/dedukt/dedukt/issues)

---

*DeduKt is open source and welcomes contributions. See our [Contributing Guide](developer-guide/contributing.md) to get started.*
