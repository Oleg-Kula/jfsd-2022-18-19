FROM openjdk:17-alpine

ENV HOME=/app

WORKDIR $HOME

COPY .env $HOME

COPY target/*.jar $HOME/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
