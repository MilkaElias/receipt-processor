FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/receiptProcessor-0.0.1-SNAPSHOT.jar receipt-processor.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "receipt-processor.jar"]
