FROM maven:3.6-jdk-11 AS MAVEN_BUILD
MAINTAINER Clément Cheradame
COPY pom.xml /build/
WORKDIR /build/
RUN mvn dependency:go-offline
COPY src /build/src/
RUN mvn -Dmaven.test.skip  package


FROM openjdk:11-jre
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/memory-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=prod", "memory-0.0.1-SNAPSHOT.jar"]
