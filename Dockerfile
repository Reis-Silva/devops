FROM openjdk

WORKDIR /app

COPY /target/artifacts/devops.jar /app/devops.jar

ENTRYPOINT ["java","-jar","devops.jar"]