FROM openjdk:11
MAINTAINER pasindu
COPY target/vault-demo.jar vault-demo.jar
ENTRYPOINT ["java","-jar","/vault-demo.jar"]
EXPOSE 8080:8080