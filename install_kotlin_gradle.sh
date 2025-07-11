#!/bin/bash
# Change To Path
PROJECT_PATH=$HOME/project/Kotlin_Basic

# Set Kotlin and Gradle versions
KOTLIN_VERSION="2.2.0"
GRADLE_VERSION="8.14.2"

# Set environment variables
echo "export PATH=$PATH:$PROJECT_PATH/gradle-$GRADLE_VERSION/bin:$PROJECT_PATH/kotlinc/bin/" | sudo tee /etc/profile.d/kotlin_gradle.sh
source /etc/profile.d/kotlin_gradle.sh

# Install unzip
if ! command -v unzip &> /dev/null; then
  sudo apt install unzip -y
else
  echo "Unzip already installed."
fi

# Install Java
if ! command -v java &> /dev/null; then
  echo "Installing OpenJDK..."
  sudo apt update
  sudo apt install openjdk-17-jdk -y
else
  echo "Java already installed."
fi

# Check if snapd is installed
# if ! command -v snap &> /dev/null; then
#   echo "snapd not found. Installing..."
#   sudo apt update
#   sudo apt install snapd -y
# else
#   echo "Snap already installed."
# fi


if ! command -v kotlinc/bin/kotlin &> /dev/null; then
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
if ! command -v gradle-$GRADLE_VERSION/bin/gradle &> /dev/null; then
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

echo "Kotlin and Gradle installation complete."
