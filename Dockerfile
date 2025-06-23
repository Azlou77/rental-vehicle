# Étape 1 : Compile et teste avec Maven
FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean verify

# Étape 2 : Exécute l'application compilée
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY --from=build /app/${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

