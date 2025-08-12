# Quick Start

Get up and running with DeduKt in minutes!

## 1. Basic Kotlin DSL Usage

```kotlin
fun main() {
    dedukt {
        // Create symbolic expressions
        val x = expression { symbol("x") }
        val y = expression { symbol("y") }
        
        // Mathematical operations (placeholder)
        println("Expression created: $x")
    }
}
```

## 2. External DSL

Create a file `example.dkt`:

```dedukt
// DeduKt external DSL (syntax in development)
let x = symbol("x")
let equation = x^2 + 2*x - 8

solve equation for x
```

Parse with DeduKt:

```kotlin
val parser = ExternalDslParser()
val ast = parser.parse(File("example.dkt").readText())
```

## 3. Interactive Notebook

Start the notebook server:

```bash
./gradlew :notebook:run
```

Open http://localhost:8080 in your browser.

## 4. Language Server

The LSP provides rich editing features for `.dkt` files:

- Syntax highlighting
- Error diagnostics  
- Auto-completion
- Hover information

## Next Steps

- Explore the [User Guide](../user-guide/kotlin-dsl.md)
- Check out [Examples](../examples/basic-usage.md)
- Read the [API Reference](../api-reference/index.md)