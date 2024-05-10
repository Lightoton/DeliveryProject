FROM openjdk:21-jdk
ARG JAR_DILE=target/*.jar
COPY ./target/Delivery.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]