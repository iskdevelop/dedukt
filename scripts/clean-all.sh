#!/bin/bash
# Clean all build artifacts

set -e

echo "Cleaning all build artifacts..."
./gradlew cleanAll

echo "Cleaning frontend build..."
cd notebook/frontend
rm -rf dist/
rm -rf node_modules/
cd ../..

echo "Cleaning documentation build..."
rm -rf docs/site/
rm -rf build/dokka/

echo "Clean completed!"