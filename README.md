# NASA APOD Explorer (Java Spring Boot)

This is a student-style implementation of the NASA APOD Explorer assignment.
Build with Java 17+ and Maven.

## Quick run
1. Copy `.env.example` to `.env` and set `NASA_API_KEY` (or use DEMO_KEY).
2. Build:
   ```
   mvn clean package
   java -jar target/apod-explorer-0.0.1-SNAPSHOT.jar
   ```
3. Open http://localhost:8080

## Project layout
```
apod-explorer-java/
├─ pom.xml
├─ README.md
├─ .env.example
├─ src/
│  ├─ main/
│  │  ├─ java/com/example/apod/
│  │  │  ├─ ApodExplorerApplication.java
│  │  │  ├─ controller/ApodController.java
│  │  │  ├─ service/ApodService.java
│  │  │  └─ dto/ApodDto.java
│  │  └─ resources/
│  │     ├─ application.properties
│  │     └─ static/
│  │        ├─ index.html
│  │        ├─ app.js
│  │        └─ styles.css
└─ .gitignore
