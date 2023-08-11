# Use a imagem base do Java (pode ser substituída pela versão específica que você precisa)
FROM openjdk:16-jdk-slim

# Copie o arquivo JAR da sua aplicação para dentro da imagem
COPY build/libs/hotel-allocation.jar /app/hotel-allocation.jar


# Define o diretório de trabalho na imagem
WORKDIR /app

# Comando para executar sua aplicação quando o container for iniciado
CMD ["java", "-jar", "/app/hotel-allocation.jar"]
