# Task Management Backend

A RESTful backend application for a Task Management System built using Java and Spring Boot.

The backend provides APIs for creating, retrieving, updating, and deleting tasks. It uses Spring Data JPA for database operations and MySQL for persistent data storage.

## Features

- Create new tasks
- Retrieve all tasks
- Retrieve a task by ID
- Update existing tasks
- Delete tasks
- Mark tasks as completed or pending
- Request validation
- Global exception handling
- DTO-based API architecture
- MySQL database integration
- CORS support for React frontend integration

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Jakarta Validation
- REST API

## Application Architecture

```text
React Frontend
      |
      | HTTP / REST API
      v
Controller Layer
      |
      v
Service Layer
      |
      v
Repository Layer
      |
      | Spring Data JPA
      v
MySQL Database
```

## Project Structure

```text
src/main/java/com/harsh/taskmanagement/
├── controller/
│   └── TaskController.java
├── dto/
│   ├── TaskRequestDto.java
│   └── TaskResponseDto.java
├── entity/
│   └── Task.java
├── exception/
├── repository/
│   └── TaskRepository.java
├── service/
└── TaskManagementBackendApplication.java
```

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Get all tasks |
| GET | `/api/tasks/{id}` | Get task by ID |
| POST | `/api/tasks` | Create a new task |
| PUT | `/api/tasks/{id}` | Update an existing task |
| DELETE | `/api/tasks/{id}` | Delete a task |

## Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE task_management_db;
```

Configure your database connection in:

```text
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_management_db
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Do not commit real database credentials to a public repository.

## Running the Application

### 1. Clone the repository

```bash
git clone https://github.com/Harshaditya1/task-management-backend.git
```

### 2. Navigate to the project

```bash
cd task-management-backend
```

### 3. Configure MySQL

Make sure MySQL is running and the `task_management_db` database exists.

Update your local database credentials in `application.properties`.

### 4. Run the application

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The backend will run on:

```text
http://localhost:8080
```

## Frontend Integration

The backend is connected to a React frontend running locally on:

```text
http://localhost:5173
```

CORS is configured to allow communication between the React frontend and Spring Boot backend during local development.

## What I Learned

Through this project, I learned how to:

- Build REST APIs using Spring Boot
- Follow Controller-Service-Repository architecture
- Use DTOs between API and application layers
- Connect Spring Boot with MySQL
- Perform CRUD operations using Spring Data JPA
- Validate incoming API requests
- Handle application exceptions
- Connect a React frontend with a Spring Boot backend
- Configure CORS for frontend-backend communication
- Test REST APIs using Postman

## Related Repository

The React frontend is available in the separate `task-management-frontend` repository.

## Future Improvements

- Spring Security authentication
- JWT-based authorization
- User registration and login
- User-specific tasks
- Pagination and sorting
- Task due dates and priorities
- Docker support
- Deployment

## Author

**Harsh Aditya**

B.Tech Computer Science & Engineering  
KIET Group of Institutions, Ghaziabad