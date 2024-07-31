##build Stage
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

##Runtime stage
From amazoncorretto:17 \
WORKDIR /app


WORKDIR /app
COPY --from=build /build /target/GestionCantine-*.jar/app/
EXPOSE 8973
