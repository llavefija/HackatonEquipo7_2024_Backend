# Dockerfile

# Usar una imagen base de Maven
FROM maven:3.8.6-openjdk-17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Usar una imagen de Java para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Copiar el jar generado
COPY --from=build /app/target/your-app-name.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
