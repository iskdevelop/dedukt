#!/bin/bash
# Build all DeduKt modules

set -e

echo "Building all DeduKt modules..."
./gradlew buildAll

echo "Building notebook frontend..."
cd notebook/frontend
npm run build
cd ../..

echo "Building documentation..."
cd docs
mkdocs build
cd ..
./gradlew dokkaHtml

echo "All builds completed successfully!"