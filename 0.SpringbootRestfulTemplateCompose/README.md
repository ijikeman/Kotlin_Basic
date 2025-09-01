# Kotlin Basic with Vue Frontend

This project contains a Spring Boot backend and a Vue.js frontend.

## Backend

The backend is a Spring Boot application located in the `0.SpringbootRestfulTemplate/backend` directory.

### API Endpoints
-   `GET /hello/us`: Returns the string "Hello World".
-   `GET /hello/jp`: Returns the string "こんにちは".

### Running the Backend

1.  Navigate to the backend directory:
    ```sh
    cd ../0.SpringbootRestfulTemplate/backend
    ```
2.  Run the Spring Boot application using the Gradle wrapper:
    ```sh
    ./gradlew bootRun
    ```
The backend server will start on `http://localhost:8080`.

## Frontend

The frontend is a Vue.js application located in the `Kotrin_Basic/frontend` directory.

### Features
-   Displays a greeting message fetched from the backend.
-   Provides buttons to switch between an English ("Hello World") and Japanese ("こんにちは") greeting.

### Running the Frontend

1.  Navigate to the frontend directory:
    ```sh
    cd frontend
    ```
2.  Install the dependencies (if you haven't already):
    ```sh
    npm install
    ```
3.  Start the frontend development server:
    ```sh
    npm run dev
    ```
The frontend application will be available at `http://localhost:5173`. Open this URL in your browser.
