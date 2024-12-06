FROM openjdk:17-jdk-alpine
ADD /target/nbiot_iffe_inventory-0.0.1-SNAPSHOT.jar nbiot_iffe_inventory-0.0.1-SNAPSHOT.jar
EXPOSE 10006
ENTRYPOINT ["java","-jar","/nbiot_iffe_inventory-0.0.1-SNAPSHOT.jar"]

