FROM openjdk:16-jdk-slim
COPY build/libs/hotel-allocation.jar /app/hotel-allocation.jar
WORKDIR /app
CMD ["java", "-jar", "/app/hotel-allocation.jar"]
