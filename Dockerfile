FROM techiescamp/jdk-17:1.0.0 AS build

# Copy the Java Application source code
COPY . /docker/nbiot_iffe_inventory/

# Build Java Application
RUN mvn -f /docker/nbiot_iffe_inventory/pom.xml clean install -DskipTests

FROM techiescamp/jre-17:1.0.0
WORKDIR /app

# Copy the JAR file from the build stage (/app)
COPY --from=build /docker/nbiot_iffe_inventory/target/*.jar ./java.jar

# Expose the port the app runs on
EXPOSE 10005

# Run the jar file
CMD ["java", "-jar", "java.jar"]