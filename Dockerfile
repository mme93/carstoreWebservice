FROM maven:3.8.2-openjdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/carstorewebservice-0.0.1-SNAPSHOT.jar /usr/local/lib/carstorewebservice.jar
EXPOSE 9999
ENTRYPOINT ["java","-jar","/usr/local/lib/carstorewebservice.jar"]