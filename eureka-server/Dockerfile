FROM openjdk:17

WORKDIR /app

COPY build/libs/eureka-server-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-Xmx50m", "-jar", "eureka-server-0.0.1-SNAPSHOT.jar"]