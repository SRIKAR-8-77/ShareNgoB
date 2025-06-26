# === Builder Stage ===
FROM eclipse-temurin:24-jdk AS builder
WORKDIR /app

COPY . .

# ✅ Add execute permission to mvnw
RUN chmod +x mvnw

# ✅ Build the Spring Boot project
RUN ./mvnw clean package -DskipTests

# === Runtime Stage ===
FROM eclipse-temurin:24-jdk
WORKDIR /app

# ✅ Copy the built JAR from builder image
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
