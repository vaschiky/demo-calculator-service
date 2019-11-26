# Build demo-calculator-service

FROM openjdk:8-jre

WORKDIR /app

ARG JAR_FILE=target/demo-calculator-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} demo-calculator-service-0.0.1-SNAPSHOT.jar

EXPOSE 7001

ENTRYPOINT ["java","-jar","/app/demo-calculator-service-0.0.1-SNAPSHOT.jar"]
