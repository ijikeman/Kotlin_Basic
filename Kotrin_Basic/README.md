# Kotlin Basic with Vue Frontend

This project contains a Spring Boot backend and a Vue.js frontend.

## Running the Backend

The backend is located in the `0.SpringbootRestfulTemplate/backend` directory.

1.  Navigate to the backend directory:
    ```sh
    cd ../0.SpringbootRestfulTemplate/backend
    ```
2.  Run the Spring Boot application using the Gradle wrapper:
    ```sh
    ./gradlew bootRun
    ```
The backend server will start on `http://localhost:8080`.

## Running the Frontend

The frontend is located in the `Kotrin_Basic/frontend` directory.

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
The frontend application will be available at `http://localhost:5173`. Open this URL in your browser, and you should see the "Hello World" message fetched from the backend.
