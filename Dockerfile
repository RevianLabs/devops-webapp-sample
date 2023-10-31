FROM openjdk:18-alpine AS builder

ADD . /app
WORKDIR /app
RUN ./mvnw -DskipTests=true --batch-mode clean install

FROM openjdk:18-alpine

COPY --from=builder /app/target/*.jar /app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]