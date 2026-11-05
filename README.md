# Codomax Spring Boot REST API – User Management System

A learning project demonstrating a Java 17 REST API with Spring Boot, Spring MVC, Spring Data JPA, Hibernate and MySQL.

## Features
- Create, list, retrieve, update and delete users (CRUD)
- Controller → Service → Repository layered architecture
- JPA/Hibernate persistence with MySQL
- JSON request and response handling
- Jakarta validation for incoming data
- Centralized exception handling with useful HTTP status codes
- Duplicate-email detection
- Postman collection included
- Docker Compose configuration for MySQL

## Requirements
- JDK 17+
- Maven 3.9+
- MySQL 8+ or Docker Desktop with Docker Compose
- Postman (optional)

## Start the database
Recommended: from this project directory run:

```bash
docker compose up -d
```

This starts MySQL at `localhost:3306`, database `codomax_users`, username `root`, password `root`.

Alternatively, start your own MySQL server and run `database/schema.sql` in MySQL Workbench. Change the connection details in `src/main/resources/application.properties` if needed.

> The included credentials are for local learning only. Do not use the root account or sample password in a production environment.

## Run the application
Open a terminal in the project root:

```bash
mvn spring-boot:run
```

Or package and run:

```bash
mvn clean package
java -jar target/springboot-rest-api-1.0.0.jar
```

Base URL: `http://localhost:8080`

Environment overrides:
- `DB_URL` (default points to local `codomax_users`)
- `DB_USERNAME` (default `root`)
- `DB_PASSWORD` (default `root`)
- `SERVER_PORT` (default `8080`)

Hibernate creates/updates the `users` table at startup.

## REST endpoints

| Method | Endpoint | Purpose | Success |
|---|---|---|---|
| POST | `/api/users` | Create a user | 201 |
| GET | `/api/users` | List all users | 200 |
| GET | `/api/users/{id}` | Find one user | 200 |
| PUT | `/api/users/{id}` | Update a user | 200 |
| DELETE | `/api/users/{id}` | Delete a user | 204 |

POST and PUT JSON body:

```json
{
  "name": "Aarav Sharma",
  "email": "aarav@example.com",
  "phone": "9876543210",
  "age": 22
}
```

## Test using Postman
1. Open Postman and click **Import**.
2. Select `postman/Codomax-User-Management-API.postman_collection.json`.
3. Send **Create user** first.
4. Copy the returned `id` into the collection variable `userId`.
5. Try Get all, Get by ID, Update and Delete.

## Example cURL
```bash
curl http://localhost:8080/api/users
```

## Structure
```text
src/main/java/com/codomax/usermanagement/
  controller/UserController.java
  dto/UserRequest.java
  entity/User.java
  exception/
  repository/UserRepository.java
  service/UserService.java
  UserManagementApplication.java
src/main/resources/application.properties
database/schema.sql
postman/Codomax-User-Management-API.postman_collection.json
docker-compose.yml
pom.xml
README.md
```

## Learning outcomes
HTTP methods, REST design, Spring Boot, MVC layering, JSON processing, JPA/Hibernate, MySQL CRUD, validation and custom exception handling.

This is an educational starter project. For production, add authentication/authorization, pagination, database migrations, integration tests, logging and managed secrets.
