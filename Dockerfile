FROM maven:3.5.2-jdk-8-alpine
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
