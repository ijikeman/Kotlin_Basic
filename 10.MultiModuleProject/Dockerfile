# Stage 1: Build the application
FROM eclipse-temurin:17.0.16_8-jdk-jammy AS builder

WORKDIR /workspace

# Copy the Gradle wrapper
COPY gradlew .
COPY gradle ./gradle

# Copy the build configuration files
COPY settings.gradle .
COPY build.gradle.kts .

# Copy the source code
COPY application/ ./application/
COPY library/ ./library/

# Build the application
RUN chmod +x ./gradlew
RUN ./gradlew build
RUN ./gradlew bootJar

# # Stage 2: Create the final production image
# FROM eclipse-temurin:17.0.16_8-jdk-jammy

# WORKDIR /app

# # Create a non-root user
# RUN useradd -m appuser
# USER appuser

# # Copy the executable JAR from the builder stage
# COPY --from=builder /workspace/application/build/libs/application-0.0.1-SNAPSHOT.jar ./application.jar

# # Expose the application port
# EXPOSE 8080

# # Run the application
# ENTRYPOINT ["java", "-jar", "./application.jar"]
