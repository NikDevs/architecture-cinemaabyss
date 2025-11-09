FROM maven:3-eclipse-temurin-21-alpine

WORKDIR /app
COPY . ./
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "package"]

ENV PORT 8082
EXPOSE $PORT

CMD ["java", "-Dserver.port=${PORT}", "-jar", "target/events-0.0.1-SNAPSHOT.jar"]
