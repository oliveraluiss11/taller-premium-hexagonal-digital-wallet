# Utiliza una imagen de Maven como base para compilar tu aplicación
FROM maven:3.8.4-eclipse-temurin-17 AS build

# Copia el código fuente de tu aplicación al contenedor
COPY . /app

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Ejecuta la compilación de tu aplicación
RUN mvn clean install -DskipTests

# Crea una imagen más ligera basada en una imagen de OpenJDK 17
FROM eclipse-temurin:17

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR construido desde la etapa de compilación a esta etapa
COPY --from=build /app/target/transfer-service-*.jar /app/transfer-service.jar

# Configura el comando de entrada para ejecutar la aplicación Java
ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8", "-jar", "/app/transfer-service.jar"]