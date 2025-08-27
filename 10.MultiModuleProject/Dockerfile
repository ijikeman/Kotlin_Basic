# Stage 1: Build the application
# FROM eclipse-temurin:21-jre-jammy AS builder
FROM eclipse-temurin:17.0.16_8-jdk-jammy AS builder

WORKDIR /workspace

# Copy the entire project
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .
COPY gradlew.bat .
COPY gradle ./gradle
COPY application ./application
COPY library ./library

# Build the application
RUN chmod +x ./gradlew
# mainのクラスでBuildする
RUN ./gradlew :application:bootJar

# Stage 2: Create the final production image
# FROM eclipse-temurin:21-jre-jammy
FROM eclipse-temurin:17.0.16_8-jdk-jammy
WORKDIR /app

# Create a non-root user
RUN useradd -m -s /bin/bash appuser
USER appuser

# Copy the executable JAR from the builder stage
COPY --from=builder /workspace/application/build/libs/*.jar ./application.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "./application.jar"]
