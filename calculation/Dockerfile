FROM openjdk:17

WORKDIR /app

COPY build/libs/calculation-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-Xmx50m", "-jar", "calculation-0.0.1-SNAPSHOT.jar"]