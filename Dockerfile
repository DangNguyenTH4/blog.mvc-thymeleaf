# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
RUN apk add --no-cache bash

# copy WAR into image
COPY target/dangnt-0.0.1-SNAPSHOT.jar /app.jar
#COPY run.sh /run.sh
#COPY run.bat /run.bat
ENTRYPOINT ["/usr/bin/java","-DurlDataSource=jdbc:postgresql://host.docker.internal:5432/thymeleaf", "-jar","/app.jar"]