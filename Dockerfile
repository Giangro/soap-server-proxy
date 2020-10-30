FROM maven:3.6.1-jdk-11-slim AS build  
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:11-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["/bin/sh", "-c", "sleep 10000"]
#ENTRYPOINT ["java", "-XX:+ExitOnOutOfMemoryError", "-XX:+HeapDumpOnOutOfMemoryError", "-XshowSettings:vm", "-XX:NativeMemoryTracking=summary", "-jar", "app.jar"]
