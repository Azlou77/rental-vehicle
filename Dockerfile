# Select your image
FROM eclipse-temurin:21-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

# Exposition du port utilisé par Spring Boot
EXPOSE 8080

# Commande pour lancer l’application
ENTRYPOINT ["java", "-jar", "app.jar"]
