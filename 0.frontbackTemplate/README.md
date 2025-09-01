# Front-end and Back-end Template

This is a simple project template with a Spring Boot backend and a Vue.js frontend.

## How to Run

You need two terminals to run both the backend and frontend servers simultaneously.

### 1. Run the Backend

1.  Navigate to the `backend` directory:
    ```bash
    cd backend
    ```
2.  Run the Spring Boot application using the Gradle wrapper:
    ```bash
    ./gradlew bootRun
    ```
    The backend server will start on `http://localhost:8080`.

### 2. Run the Frontend

1.  Navigate to the `frontend` directory:
    ```bash
    cd frontend
    ```
2.  Install the dependencies (only needed for the first time):
    ```bash
    npm install
    ```
3.  Start the Vite development server:
    ```bash
    npm run dev
    ```
    The frontend development server will start on `http://localhost:5173` (or the next available port).

### Accessing the Application

Open your browser and navigate to `http://localhost:5173`. The frontend will load and fetch a message from the backend.
