FROM openjdk:17-jdk-alpine
ADD /target/nbiot_iffe_inventory-0.0.1-SNAPSHOT.jar nbiot_iffe_inventory-0.0.1-SNAPSHOT.jar
EXPOSE 10005
ENTRYPOINT ["java","-jar","/nbiot_iffe_inventory-0.0.1-SNAPSHOT.jar"]


# Build Java Application
#RUN mvn -f /docker/nbiot_iffe_inventory/pom.xml clean install -DskipTests
#FROM techiescamp/jre-17:1.0.0
#WORKDIR /app
