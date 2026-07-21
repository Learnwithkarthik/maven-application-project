# Employee Portal

A browser-based Spring Boot application created to demonstrate:

- Maven project structure
- Maven lifecycle commands
- Java compilation
- Unit and controller testing
- Executable JAR creation
- Application versioning
- Publishing JAR files to Nexus or JFrog Artifactory

## Application Features

- Login page
- Employee dashboard
- Employee list
- Application version display
- Session-based logout

## Demo Login

Username: `admin`  
Password: `admin123`

> This fixed credential is only for a classroom demo. It is not suitable for production.

## Prerequisites

- Java 17 or later
- Maven 3.6.3 or later
- Git

Check installations:

    java -version
    mvn -version
    git --version

## Run with Maven

    mvn spring-boot:run

Open:

    http://localhost:8080

## Create the JAR

    mvn clean package

Generated JAR:

    target/employee-portal-1.0.0-SNAPSHOT.jar

Run the JAR:

    java -jar target/employee-portal-1.0.0-SNAPSHOT.jar

## Maven Lifecycle Demo

    mvn validate
    mvn compile
    mvn test
    mvn package
    mvn verify
    mvn install

The Nexus/JFrog deployment configuration will be added in the next stage of the demo.

## Upload to GitHub

Create an empty GitHub repository, then run:

    git init
    git add .
    git commit -m "Initial employee portal application"
    git branch -M main
    git remote add origin https://github.com/YOUR_USERNAME/employee-portal.git
    git push -u origin main
