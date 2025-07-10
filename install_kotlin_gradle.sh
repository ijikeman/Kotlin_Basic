#!/bin/bash

# Install unzip
sudo apt install unzip -y

# Install Java
echo "Installing OpenJDK..."
sudo apt update
sudo apt install openjdk-17-jdk -y

# Set Kotlin and Gradle versions
KOTLIN_VERSION="2.2.0"
GRADLE_VERSION="8.14.2"

# Check if Kotlin is already installed
if ! command -v kotlinc &> /dev/null; then
  echo "Kotlin not found. Installing..."
  KOTLIN_DIST="kotlin-compiler-$KOTLIN_VERSION"
  KOTLIN_URL="https://github.com/JetBrains/kotlin/releases/download/v$KOTLIN_VERSION/$KOTLIN_DIST.zip"
  KOTLIN_HOME="."

  echo "Downloading Kotlin..."
  wget -q "$KOTLIN_URL" -O /tmp/$KOTLIN_DIST.zip

  echo "Installing Kotlin..."
  mkdir -p "$KOTLIN_HOME"
  unzip -q /tmp/$KOTLIN_DIST.zip -d "$KOTLIN_HOME"
  export PATH="$PATH:$KOTLIN_HOME/$KOTLIN_DIST/bin"
else
  echo "Kotlin already installed."
fi

# Check if Gradle is already installed
if ! command -v gradle &> /dev/null; then
  echo "Gradle not found. Installing..."
  GRADLE_DIST="gradle-$GRADLE_VERSION-bin"
  GRADLE_URL="https://services.gradle.org/distributions/$GRADLE_DIST.zip"
  GRADLE_HOME="."

  echo "Downloading Gradle..."
  wget -q "$GRADLE_URL" -O /tmp/$GRADLE_DIST.zip

  echo "Installing Gradle..."
  mkdir -p "$GRADLE_HOME"
  unzip -q /tmp/$GRADLE_DIST.zip -d "$GRADLE_HOME"
  export PATH="$PATH:$GRADLE_HOME/$GRADLE_DIST/bin"
else
  echo "Gradle already installed."
fi

# Set environment variables
echo 'export PATH="$PATH:$KOTLIN_HOME/$KOTLIN_DIST/bin:$GRADLE_HOME/$GRADLE_DIST/bin"' | sudo tee /etc/profile.d/kotlin_gradle.sh

echo "Kotlin and Gradle installation complete."
