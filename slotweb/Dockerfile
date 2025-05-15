FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# Fix: give executable permission to the Maven wrapper
RUN chmod +x mvnw

# Now install dependencies (skip tests for faster build)
RUN ./mvnw clean install -DskipTests

EXPOSE 8080

CMD ["./mvnw", "spring-boot:run"]
