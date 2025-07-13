# Hyperflows

A multi-module Maven project built with Java 17.

## Project Structure

```
hyperflows/
├── models/          # Data models and entities
├── core/            # Core business logic and services
├── server/          # Spring Boot server application
└── pom.xml          # Parent POM
```

## Modules

### Models
Contains all data models and entities used across the application.
- **Group ID**: `space.hypercode.flows`
- **Artifact ID**: `hyperflows-models`

### Core
Contains core business logic, services, and utilities.
- **Group ID**: `space.hypercode.flows`
- **Artifact ID**: `hyperflows-core`
- **Dependencies**: models

### Server
Spring Boot web application server.
- **Group ID**: `space.hypercode.flows`
- **Artifact ID**: `hyperflows-server`
- **Dependencies**: models, core
- **Default Port**: 8080

## Requirements

- Java 17 or higher
- Maven 3.6.0 or higher

## Building the Project

To build all modules:
```bash
mvn clean install
```

To build a specific module:
```bash
cd <module-name>
mvn clean install
```

## Running the Server

To run the Spring Boot server:
```bash
cd server
mvn spring-boot:run
```

Or run the compiled JAR:
```bash
java -jar server/target/hyperflows-server-1.0.0-SNAPSHOT.jar
```

## Testing

Run all tests:
```bash
mvn test
```

Run tests for a specific module:
```bash
cd <module-name>
mvn test
```

## Health Check

Once the server is running, you can check the health endpoint:
```bash
curl http://localhost:8080/api/health
```

## API Documentation

The server includes Spring Boot Actuator endpoints:
- Health: `/actuator/health`
- Info: `/actuator/info`
- Metrics: `/actuator/metrics`

## Development

This project uses:
- Java 17
- Maven for dependency management
- Spring Boot 3.1.2 for the server module
- JUnit 5 for testing
