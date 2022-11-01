FROM openjdk:8-jdk-alpine
WORKDIR /demo
COPY ./target/demo-0.0.1-SNAPSHOT.jar /demo
EXPOSE 8080
CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]