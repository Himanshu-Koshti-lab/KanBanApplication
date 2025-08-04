FROM eclipse-temurin:21-jdk
LABEL authors="himanshu"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} kanban-tool.jar
ENTRYPOINT ["java", "-jar", "/kanban-tool.jar"]