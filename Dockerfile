FROM maven:latest

LABEL authors="hetah"

WORKDIR /app

COPY pom.xml /app/

COPY . /app/

RUN mvn package

CMD ["java", "-jar", "target/trip_cost.jar"]

