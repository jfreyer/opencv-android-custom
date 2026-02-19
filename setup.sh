#!/usr/bin/env bash
#
# setup.sh — Run once after cloning to initialize the project
#
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

echo "=== OpenCV Android Project Setup ==="
echo ""

# 1. Generate Gradle wrapper (requires Gradle to be installed on the system)
if command -v gradle &>/dev/null; then
    echo "Generating Gradle wrapper..."
    gradle wrapper --gradle-version 8.11.1
    echo "✓ Gradle wrapper generated"
else
    echo "⚠  Gradle not found on PATH."
    echo "   Install it (https://gradle.org/install/) and run:"
    echo "   gradle wrapper --gradle-version 8.11.1"
    echo ""
    echo "   Or if you have Android Studio, use its bundled Gradle:"
    echo "   /path/to/android-studio/gradle/gradle-8.x/bin/gradle wrapper --gradle-version 8.11.1"
fi

echo ""
echo "=== Next steps ==="
echo "1. Run the build script:    ./scripts/build_opencv_android.sh"
echo "2. Commit the artifacts:    git add -A && git commit -m 'build: OpenCV native libs'"
echo "3. Tag a release:           git tag 4.10.0-1 && git push origin main --tags"
echo "4. JitPack builds the AAR automatically from the tag."
echo ""
echo "Replace YOUR_USERNAME in README.md and build.gradle with your GitHub username."
