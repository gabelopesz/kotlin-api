FROM openjdk:17 AS build

WORKDIR /app

COPY . .

RUN ./gradlew build

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/build/libs/api-all.jar /app/api-all.jar

EXPOSE 8080

CMD ["java", "-jar", "api-all.jar"]