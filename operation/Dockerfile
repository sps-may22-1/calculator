FROM openjdk:17

WORKDIR /app

COPY build/libs/operation-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-Xmx50m", "-jar", "operation-0.0.1-SNAPSHOT.jar"]