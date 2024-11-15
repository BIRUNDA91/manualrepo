FROM eclipse-temurin:17
COPY target/manual.jar manual.jar
CMD ["java","-jar","manual.jar"]