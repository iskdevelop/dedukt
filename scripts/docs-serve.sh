#!/bin/bash
# Serve documentation locally

set -e

echo "Starting documentation server..."
cd docs
mkdocs serve --dev-addr=0.0.0.0:8000 &
MKDOCS_PID=$!

echo "Documentation server started at http://localhost:8000"
echo "Press Ctrl+C to stop"

# Trap Ctrl+C and cleanup
trap "kill $MKDOCS_PID 2>/dev/null; exit" INT

wait $MKDOCS_PID