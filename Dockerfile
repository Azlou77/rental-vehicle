# Select your image
FROM eclipse-temurin:21-jdk-alpine
# Change directory
WORKDIR  /rental-vehicle
#Copy the jar file into the image
COPY target/rental-vehicle-0.0.1-SNAPSHOT.jar app.jar
# Exposition du port utilisé par Spring Boot
EXPOSE 8080
# Commande pour lancer l’application
ENTRYPOINT ["java","-jar","/app.jar"]