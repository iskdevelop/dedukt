# DeduKt

[![Build Status](https://github.com/dedukt/dedukt/workflows/CI/badge.svg)](https://github.com/dedukt/dedukt/actions)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-blue.svg)](https://kotlinlang.org)

**DeduKt** is a symbolic computation, mathematical reasoning, and simulation platform built with Kotlin Multiplatform.

## Features

- **Type-safe Kotlin DSL** for symbolic computation
- **Standalone DSL** with custom syntax
- **Language Server Protocol** for rich IDE support
- **Interactive notebook** interface
- **Cross-platform** (JVM, JS, Native)

## Quick Start

### Kotlin DSL
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

### External DSL
```dedukt
let x = symbol("x")
let equation = x^2 + 2*x - 8
solve equation for x
```

### Interactive Notebook
```bash
./gradlew :notebook:run
# Open http://localhost:8080
```

## Documentation

- **[Getting Started](https://dedukt.io/getting-started/installation/)** - Installation and setup
- **[User Guide](https://dedukt.io/user-guide/kotlin-dsl/)** - How to use DeduKt
- **[API Reference](https://dedukt.io/api-reference/)** - Complete API documentation
- **[Examples](https://dedukt.io/examples/basic-usage/)** - Sample code and tutorials

##️ Development

### Prerequisites
- Java 17+
- Node.js 16+
- Python 3.8+

### Setup
```bash
git clone https://github.com/iskdevelop/dedukt.git
cd dedukt
./scripts/setup-dev.sh
```

### Build
```bash
./scripts/build-all.sh
```

### Test
```bash
./scripts/test-all.sh
```

## Project Structure

```
dedukt/
├── core/           # Core computation engine
├── dsl/            # DSL implementation (internal + external)
├── lsp/            # Language Server Protocol
├── notebook/       # Web-based notebook interface
├── docs/           # Documentation
└── scripts/        # Development utility scripts
```

## Contributing

We welcome contributions! Please see our [Contributing Guide](CONTRIBUTING.md) for details.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Built with [Kotlin Multiplatform](https://kotlinlang.org/lp/mobile/)
- LSP support via [Eclipse LSP4J](https://github.com/eclipse/lsp4j)
- Web framework: [Ktor](https://ktor.io/)
- Documentation: [MkDocs Material](https://squidfunk.github.io/mkdocs-material/)
