# Stage 1: Build the frontend
FROM node:lts AS frontend
WORKDIR /app/frontend
COPY frontend/package.json frontend/package-lock.json ./
RUN npm install
COPY frontend/ ./
RUN npm run build

# # Stage 2: Build the backend with frontend assets
# FROM gradle:8.5-jdk17-jammy AS builder
# WORKDIR /app
# # Copy backend source
# COPY backend/ ./backend/
# # Copy built frontend assets to Spring Boot's static directory
# COPY --from=frontend /app/frontend/dist ./backend/src/main/resources/static
# # Build the Spring Boot application
# WORKDIR /app/backend
# RUN ./gradlew bootJar --no-daemon

# # Stage 3: Create the final image
# FROM eclipse-temurin:17-jre-jammy
# WORKDIR /app
# # Copy the executable JAR from the builder stage
# COPY --from=builder /app/backend/build/libs/*.jar ./app.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "app.jar"]
