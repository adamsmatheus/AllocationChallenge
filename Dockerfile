FROM openjdk:16-jdk-slim
ARG JAR_FILE=target/*.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
