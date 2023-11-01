FROM openjdk:11
WORKDIR /app
COPY target/EcoTech-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 10000
CMD ["java", "-jar", "app.jar"]
