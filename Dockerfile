FROM openjdk:21

WORKDIR /app

COPY target/pagos-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "pagos-0.0.1-SNAPSHOT.jar"]