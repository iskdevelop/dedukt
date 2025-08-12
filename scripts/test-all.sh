#!/bin/bash
# Run all tests for DeduKt

set -e

echo "Running all tests..."
./gradlew testAll

echo "Running frontend tests..."
cd notebook/frontend
npm test
cd ../..

echo "All tests completed!"
