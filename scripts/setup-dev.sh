#!/bin/bash
# DeduKt Development Environment Setup Script

set -e

echo "Setting up DeduKt development environment..."

# Check if required tools are installed
command -v java >/dev/null 2>&1 || { echo "Java is required but not installed. Aborting." >&2; exit 1; }
command -v node >/dev/null 2>&1 || { echo "Node.js is required but not installed. Aborting." >&2; exit 1; }
command -v python3 >/dev/null 2>&1 || { echo "Python 3 is required but not installed. Aborting." >&2; exit 1; }

# Install Python dependencies for docs
echo "Installing Python dependencies..."
pip3 install -r docs/requirements.txt

# Install Node.js dependencies for notebook frontend
echo "Installing Node.js dependencies..."
cd notebook/frontend && npm install && cd ../..

# Make gradlew executable
chmod +x gradlew

# Initial build to verify setup
echo "Running initial build..."
./gradlew build

echo "Development environment setup complete!"
echo "Run './scripts/docs-serve.sh' to start documentation server"
echo "Run './gradlew :notebook:run' to start notebook server"