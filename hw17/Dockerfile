FROM java:8-jdk-alpine
ARG JAR_FILE=/target/hw17-1.0.0.jar
WORKDIR /opt/otus/hw
COPY ${JAR_FILE} hw17.jar
ENTRYPOINT ["java","-jar","hw17.jar"]