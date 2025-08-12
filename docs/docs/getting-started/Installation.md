# Installation

## Prerequisites

- **Java 17+** (for JVM target)
- **Node.js 16+** (for notebook frontend)
- **Python 3.8+** (for documentation)

## Gradle Dependency

Add DeduKt to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.iskportal.dedukt:core:0.1.0-SNAPSHOT")
    implementation("com.iskportal.dedukt:dsl:0.1.0-SNAPSHOT")
}
```

## Development Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/iskdevelop/dedukt.git
   cd dedukt
   ```

2. **Run setup script**:
   ```bash
   ./scripts/setup-dev.sh
   ```

3. **Build all modules**:
   ```bash
   ./scripts/build-all.sh
   ```

## Language Server

Install the DeduKt LSP for your editor:

### VS Code

1. Build the LSP server:
   ```bash
   ./gradlew :lsp:installDist
   ```

2. Install the VS Code extension (coming soon)

### IntelliJ IDEA

DeduKt plugin for IntelliJ IDEA is in development.

## Verification

Test your installation:

```bash
./scripts/test-all.sh
```