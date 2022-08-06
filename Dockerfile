FROM maven:3.8.6-openjdk-18 AS builder

ADD . /app
WORKDIR /app
RUN mvn --batch-mode clean install

FROM openjdk:18-jdk

COPY --from=builder /app/target/*.jar /app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]