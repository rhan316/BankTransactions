FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/Transactions-0.0.1-SNAPSHOT.jar /app/Transactions.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/Transactions.jar"]