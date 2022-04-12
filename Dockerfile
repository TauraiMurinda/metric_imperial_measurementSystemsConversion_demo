FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/metric_imperial_measurementSystemsConversion_demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]