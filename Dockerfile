# Dockerfile
# docker pull eclipse-temurin:17-jdk-jammy

# Simple Docker file 
# -----------------------------------------#
# FROM eclipse-temurin:17-jdk-jammy
# VOLUME /tmp
# COPY target/*.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
# -----------------------------------------#

# Docker file using mvn to build the project
# -----------------------------------------#
# FROM eclipse-temurin:17-jdk-jammy
# WORKDIR /app
# COPY .mvn/ .mvn
# COPY mvnw pom.xml ./
# # The following line is needed to grant execute permission to mvn
# RUN chmod +x mvnw 
# RUN ./mvnw dependency:go-offline
# COPY src ./src
# CMD ["./mvnw", "spring-boot:run"]
# -----------------------------------------#


# Dockerfile using multi layered build of Spring boot project
# -----------------------------------------#
FROM eclipse-temurin:17-jdk-jammy as build
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# The following line is needed to grant execute permission to mvn
RUN chmod +x mvnw 
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /opt/app
# Exposes the port 8080 in the container
EXPOSE 8080
COPY --from=build /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]
# -----------------------------------------#
