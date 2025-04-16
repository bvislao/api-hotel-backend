# Usar una imagen base con Java 17
FROM openjdk:21-jdk-slim

# Directorio donde se colocará la aplicación en el contenedor
WORKDIR /app

# Copiar el archivo jar del proyecto al directorio /app en el contenedor
COPY build/libs/project-0.0.1-SNAPSHOT.jar /app/project.jar

# Exponer el puerto que usa la aplicación
EXPOSE 8085

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/project.jar"]


# first => ./gradlew clean build
# second => docker build --platform linux/amd64 -t bvislao/api-hotel-backend:lastest .
# third => docker login
# fourth => docker push bvislao/api-hotel-backend:lastest
#update lastest from render

