FROM openjdk:17

WORKDIR /app

COPY build/libs/config-server-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-Xmx50m", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]