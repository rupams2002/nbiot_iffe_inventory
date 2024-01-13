FROM techiescamp/jdk-17:1.0.0 AS build

# Copy the Java Application source code
#COPY . /docker/nbiot_iffe_inventory/

# Build Java Application
#RUN mvn -f /docker/nbiot_iffe_inventory/pom.xml clean install -DskipTests

FROM techiescamp/jre-17:1.0.0
WORKDIR /app

# Copy the JAR file from the build stage (/app)
#COPY --from=build /docker/nbiot_iffe_inventory/target/*.jar ./java.jar

# Expose the port the app runs on
#EXPOSE 10005

# Run the jar file
#CMD ["java", "-jar", "java.jar"]


# ---------------------------------------------------------------------------------------------------------
# Build stage
#FROM maven:3.6.0-jdk-11-slim AS build
FROM maven:3.6.0-jdk-17-slim AS build
COPY src /home/devops/docker/app/src  
COPY pom.xml /home/devops/docker/app/src
RUN mvn -f /home/devops/docker/app/src/pom.xml clean package


# Package stage
FROM openjdk:17-jre-slim
COPY --from=build /home/devops/docker/app/target/nbiot_iffe_inventory-0.0.1-SNAPSHOT.jar /nbiot_iffe_inventory-0.0.1-SNAPSHOT.jar
EXPOSE 10005
ENTRYPOINT ["java","-jar","/nbiot_iffe_inventory-0.0.1-SNAPSHOT.jar"]